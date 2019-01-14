package com.weichuang;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HDFSDemo1 {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop101:8020"), configuration, "root");
        // 2 把本地文件上传到文件系统中
        fileSystem.copyFromLocalFile(new Path("d://xiyou.txt"),new Path("/user/weichuang/input/xiyou.txt"));
        // 3 关闭资源
        fileSystem.close();
    }
}
