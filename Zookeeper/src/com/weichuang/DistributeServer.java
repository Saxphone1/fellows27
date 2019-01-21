package com.weichuang;

import org.apache.zookeeper.*;

import java.io.IOException;

public class DistributeServer {
    private String connect = "hadoop101:2181,hadoop102:2181,hadoop103:2181";
    private int sessionTime = 2000;
    private ZooKeeper zooKeeper = null;
    public static void main(String[] args) throws Exception {
        DistributeServer ds = new DistributeServer();
        //创建一个连接
        ds.connect();
        //注册节点
        ds.createNode(args[0]);
        //业务逻辑
        ds.work();

    }
    public void connect() throws Exception {

        zooKeeper = new ZooKeeper(connect, sessionTime, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });
    }
    public void createNode(String hostname) throws KeeperException, InterruptedException {
        String s = zooKeeper.create("/servers/server", hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(s);
    }
    public void work() throws InterruptedException {
        System.out.println("-------job--------");
        Thread.sleep(Long.MAX_VALUE);
    }
}
