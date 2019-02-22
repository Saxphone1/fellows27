package com.weibo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeiboUtil {
    private static Configuration conf = null;
    private static Connection connection = null;
    private static HBaseAdmin admin = null;
    static {
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "192.168.1.101");
        try {
            connection = ConnectionFactory.createConnection(conf);
            admin = (HBaseAdmin)connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createNameSpace(String ns) throws IOException {
        NamespaceDescriptor nsd = NamespaceDescriptor.create(ns).build();
        admin.createNamespace(nsd);
    }

    public static void createTable(String tableName,int version,String... cfs) throws IOException {
        HTableDescriptor htd = new HTableDescriptor(TableName.valueOf(tableName));
        for (String cf : cfs) {
            HColumnDescriptor hcd = new HColumnDescriptor(cf);
            hcd.setMaxVersions(version);
            htd.addFamily(hcd);
        }
        admin.createTable(htd);

    }
    public static void putContent(String uid,String val) throws IOException {

        Table conTable = connection.getTable(TableName.valueOf("weibo:content"));
        Table userTable = connection.getTable(TableName.valueOf("weibo:users"));
        Table inTable = connection.getTable(TableName.valueOf("weibo:inbox"));
        //1,将内容插入到content表
        long ts = System.currentTimeMillis();
        String rowkey = uid +"_"+ ts;
        Put p = new Put(rowkey.getBytes());
        p.addColumn("info".getBytes(),"content".getBytes(),val.getBytes());
        conTable.put(p);
        //2,从users表找到uid的fans

        Get g = new Get(uid.getBytes());
        g.addFamily("fans".getBytes());

        Result result = userTable.get(g);
        Cell[] cells = result.rawCells();
        if(cells.length <=0){
            return;
        }
        List<Put> pl = new ArrayList<>();
        for (Cell cell : cells) {
            byte[] bytes = CellUtil.cloneQualifier(cell);//B、C....
            //3. 根据fans 在inbox表中加入数据
            Put inboxP = new Put(bytes);
            inboxP.addColumn("info".getBytes(),uid.getBytes(),rowkey.getBytes());
            pl.add(inboxP);

        }
        inTable.put(pl);
    }
    public static void attendUser(String uid,String... attender) throws IOException {
        Table conTable = connection.getTable(TableName.valueOf("weibo:content"));
        Table userTable = connection.getTable(TableName.valueOf("weibo:users"));
        Table inTable = connection.getTable(TableName.valueOf("weibo:inbox"));
        //1.在user里面添加attends

        Put p = new Put(uid.getBytes());
        List<Put> userL = new ArrayList<>();
        for (String s : attender) {//B C
            p.addColumn("attends".getBytes(),s.getBytes(),s.getBytes());
            //2 在user里面添加fans
            Put p1 = new Put(s.getBytes());
            p1.addColumn("fans".getBytes(),uid.getBytes(),uid.getBytes());
            userL.add(p1);
        }
        userL.add(p);
        userTable.put(userL);

        //3.在inbox添加数据
        Put inP = new Put(uid.getBytes());
        for (String s : attender) {
            Scan scan = new Scan(s.getBytes(),(s+"|").getBytes());
            ResultScanner scanner = conTable.getScanner(scan);
            for (Result result : scanner) {
                byte[] rowkey = result.getRow();//rowkey
                inP.addColumn("info".getBytes(),s.getBytes(),rowkey);
            }
        }
        inTable.put(inP);
    }

    public static void removeUser(String uid,String user) throws IOException {
        Table userTable = connection.getTable(TableName.valueOf("weibo:users"));
        Table inTable = connection.getTable(TableName.valueOf("weibo:inbox"));
        //1.移除user uid行attends列族user列

        Delete del = new Delete(uid.getBytes());
        List<Delete> dList = new ArrayList<>();
        del.addColumn("attends".getBytes(),user.getBytes());
        dList.add(del);

        //2.移除user user行fans列族uid列
        Delete del1 = new Delete(user.getBytes());
        del1.addColumn("fans".getBytes(),uid.getBytes());
        dList.add(del1);
        userTable.delete(dList);


        //3.移除inbox uid行user列
        Delete del2 = new Delete(uid.getBytes());
        del2.addColumn("info".getBytes(),user.getBytes());
        inTable.delete(del2);
    }
}
