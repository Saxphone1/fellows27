package com.weichuang;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HDFSDemo1 {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop101:8020"), configuration, "root");
//        // 2 把本地文件上传到文件系统中
//        fileSystem.copyFromLocalFile(new Path("d://xiyou.txt"),new Path("/user/weichuang/input/xiyou.txt"));
//        fileSystem.copyToLocalFile(false,new Path("/user/weichuang/input/hello.txt"), new Path("d:/hellocopy.txt"),true);
//        fileSystem.mkdirs(new Path("/user/weichuang/output/aa/bb"));
//        fileSystem.delete(new Path("/user/weichuang/output"),true);

//        RemoteIterator<LocatedFileStatus> listFiles = fileSystem.listFiles(new Path("/"), true);
//        while (listFiles.hasNext()){
//            LocatedFileStatus lf = listFiles.next();
//            System.out.println(lf.getPath());
//            BlockLocation[] blockLocations = lf.getBlockLocations();
//            for (BlockLocation bl : blockLocations) {
//                System.out.println("block-offset:" + bl.getOffset());
//                String[] hosts = bl.getHosts();
//                for (String host : hosts) {
//                    System.out.println(host);
//                }
//            }
//        }


        // 2 获取查询路径下的文件状态信息
        FileStatus[] listStatus = fileSystem.listStatus(new Path("/user/weichuang/input"));

        // 3 遍历所有文件状态
        for (FileStatus status : listStatus) {
            if (status.isFile()) {
                System.out.println("f--" + status.getPath().getName());
            } else {
                System.out.println("d--" + status.getPath().getName());
            }
        }

        // 3 关闭资源
        fileSystem.close();
    }
}
