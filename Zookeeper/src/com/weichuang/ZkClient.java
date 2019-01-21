package com.weichuang;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ZkClient {
    private ZooKeeper zk =null;
    @Before
    public void connect() throws IOException {
        String connent = "hadoop101:2181,hadoop102:2181,hadoop103:2181";
        int sessionTime = 2000;

        zk = new ZooKeeper(connent, sessionTime, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });
    }

    @Test
    public void createNode() throws KeeperException, InterruptedException {
        String path = zk.create("/weichuang/hlm", "lindaiyu".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);
    }
    @Test
    public void getChildren() throws KeeperException, InterruptedException {

//        List<String> children = zk.getChildren("/weichuang", true);
//        for (String s:children) {
//            System.out.println(s);
//        }
//        Thread.sleep(Long.MAX_VALUE);

        List<String> children = zk.getChildren("/weichuang", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("aaaaaaaaaaaaaaaa");
                System.out.println("-------------------");
                try {
                    getChildren();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        for (String s:children) {
            System.out.println(s);
        }
        Thread.sleep(Long.MAX_VALUE);
    }
    @Test
    public void exist() throws KeeperException, InterruptedException {
        Stat exists = zk.exists("/weichdfdfduang", false);
        if(exists == null){
            System.out.println("not exits");
        }else{
            System.out.println("exits");
        }
    }
}
