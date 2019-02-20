package com.weichuang;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;

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



    public static void main(String[] args) throws IOException {
//        System.out.println(isTableExist("student"));
//        System.out.println(isTableExist("student111"));

//        createTable("teacher","info");
//        deleteTable("teacher");
        putData("student","1001","info","name","lisi");
    }
}
