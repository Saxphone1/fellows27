package com.weichuang;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.ArrayList;
import java.util.List;

public class DistributeClient {
    private String connect = "hadoop101:2181,hadoop102:2181,hadoop103:2181";
    private int sessionTime = 2000;
    private ZooKeeper zooKeeper = null;
    public static void main(String[] args) throws Exception {
        DistributeClient dc = new DistributeClient();
        //连接zookeeper
        dc.connect();
        //获取服务器列表 并 监听
        dc.getChildren();
        //业务逻辑
        dc.work();
    }

    private void work() throws InterruptedException {
        System.out.println("---------client--------");
        Thread.sleep(Long.MAX_VALUE);
    }

    public void getChildren() throws KeeperException, InterruptedException {
        ArrayList<String> serverList = new ArrayList<>();
        List<String> children = zooKeeper.getChildren("/servers", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("------掉了---------");
                try {
                    getChildren();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        for (String s:children) {
            System.out.println(s);
            //server001 server002
            byte[] data = zooKeeper.getData("/servers/" + s, false, null);
            serverList.add(new String(data));
        }
        System.out.println(serverList);
    }

    public void connect() throws Exception {
        zooKeeper = new ZooKeeper(connect, sessionTime, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });
    }
}
