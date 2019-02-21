package com.weichuang;

import org.apache.avro.generic.GenericData;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestHbase {

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


    public static boolean isTableExist(String tableName) throws IOException {
////        Configuration conf = new HBaseConfiguration();
//        Configuration conf = HBaseConfiguration.create();
//                conf.set("hbase.zookeeper.quorum", "192.168.1.101");
//        Connection connection = ConnectionFactory.createConnection(conf);
////        HBaseAdmin admin = new HBaseAdmin(conf);
//        HBaseAdmin admin = (HBaseAdmin)connection.getAdmin();
        return admin.tableExists(tableName);
    }

    public static void createTable(String tableName,String... cfs) throws IOException {

        if(isTableExist(tableName)){
            System.out.println("表已存在");
            return;
        }
        HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
        for (String cf : cfs) {
            HColumnDescriptor hc = new HColumnDescriptor(cf);
            hTableDescriptor.addFamily(hc);
        }
        admin.createTable(hTableDescriptor);

    }

    public static void deleteTable(String tableName) throws IOException {

        if(!isTableExist(tableName)){
            return;
        }
        admin.disableTable(TableName.valueOf(tableName));
        admin.deleteTable(TableName.valueOf(tableName));

    }

    public static void putData(String tableName,String key,String cf,String cn,String value) throws IOException {

//        HTable table = new HTable(conf,TableName.valueOf(tableName));
        Table table = connection.getTable(TableName.valueOf(tableName));

        Put p = new Put(key.getBytes());
        p.addColumn(cf.getBytes(),cn.getBytes(),value.getBytes());
        p.addColumn(cf.getBytes(),"sex".getBytes(),"male".getBytes());
        p.addColumn(cf.getBytes(),"age".getBytes(),"18".getBytes());

        Put p2 = new Put("1002".getBytes());

        p2.addColumn(cf.getBytes(),cn.getBytes(),value.getBytes());
        p2.addColumn(cf.getBytes(),"sex".getBytes(),"male".getBytes());
        p2.addColumn(cf.getBytes(),"age".getBytes(),"18".getBytes());

        List<Put> list = new ArrayList<>();
        list.add(p);
        list.add(p2);

        table.put(list);


    }

    public static void deleteData(String tableName,String... rows) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        List<Delete> dels = new ArrayList<>();
        for (String row : rows) {
            Delete del = new Delete(row.getBytes());
            dels.add(del);
        }
        table.delete(dels);
    }

    public static void scanTable(String tableName) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Scan sc = new Scan();
        ResultScanner scanner = table.getScanner(sc);//存的是每条数据
        for (Result result : scanner) {
            Cell[] cells = result.rawCells();
            for (Cell cell : cells) {
                System.out.println("key:" + Bytes.toString(CellUtil.cloneRow(cell)) + ",fam:" + Bytes.toString(CellUtil.cloneFamily(cell))
                        + ",Qualifier:" + Bytes.toString(CellUtil.cloneQualifier(cell)) + ",val:" + Bytes.toString(CellUtil.cloneValue(cell)));
            }
        }
    }

    public static void getRow(String tableName,String rowkey) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Get g = new Get(rowkey.getBytes());
        Result result = table.get(g);
        Cell[] cells = result.rawCells();
        for (Cell cell : cells) {
            System.out.println("key:" + Bytes.toString(CellUtil.cloneRow(cell)) + ",fam:" + Bytes.toString(CellUtil.cloneFamily(cell))
                    + ",Qualifier:" + Bytes.toString(CellUtil.cloneQualifier(cell)) + ",val:" + Bytes.toString(CellUtil.cloneValue(cell)));
        }
    }
    public static void getQualifier(String tableName,String rowkey,String cf,String cn) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Get g = new Get(rowkey.getBytes());
        g.addColumn(cf.getBytes(),cn.getBytes());
        Result result = table.get(g);
        Cell[] cells = result.rawCells();
        for (Cell cell : cells) {
            System.out.println("key:" + Bytes.toString(CellUtil.cloneRow(cell)) + ",fam:" + Bytes.toString(CellUtil.cloneFamily(cell))
                    + ",Qualifier:" + Bytes.toString(CellUtil.cloneQualifier(cell)) + ",val:" + Bytes.toString(CellUtil.cloneValue(cell)));
        }
    }


    public static void main(String[] args) throws IOException {
//        System.out.println(isTableExist("student"));
//        System.out.println(isTableExist("student111"));

//        createTable("teacher","info");
//        deleteTable("teacher");
//        putData("student","1001","info","name","lisi");
//        deleteData("student","1001");
//        scanTable("student");
//        getRow("student","1002");
        getQualifier("student","1002","info","name");
    }
}
