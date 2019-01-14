package com.weichuang;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;

public class HdfsIoDemo {
    @Test
    public void putFileToHDFS() throws Exception{
        // 1 创建配置信息对象
        Configuration configuration = new Configuration();

        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop101:8020"),configuration, "root");

        // 2 创建输入流
        InputStream inStream = new FileInputStream(new File("d:/xiyou.txt"));

        // 3 创建输出流
        FSDataOutputStream outStream = fs.create(new Path("/user/weichuang/hello1.txt"));

        // 4 流对接
            IOUtils.copyBytes(inStream, outStream, configuration);
            //5关闭
            IOUtils.closeStream(inStream);
            IOUtils.closeStream(outStream);
    }

    @Test
    public void getFileToHDFS() throws Exception{
        // 1 创建配置信息对象
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop101:8020"),configuration, "root");

        // 2创建输出流
        FileOutputStream outStream = new FileOutputStream(new File("d:/hello.txt"));
        // 3 创建输入流
        FSDataInputStream inStream = fs.open(new Path("/user/weichuang/hello1.txt"));

        // 4 流对接输出到控制台
        try{
            IOUtils.copyBytes(inStream, outStream , configuration );
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            IOUtils.closeStream(inStream);
            IOUtils.closeStream(outStream );
        }
    }
    @Test
// 定位下载第一块内容
    public void readFileSeek1() throws Exception {

        // 1 创建配置信息对象
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop101:8020"), configuration, "root");
        // 2 获取输入流路径
        Path path = new Path("/user/weichuang/input/hadoop-2.7.2.tar.gz");
        // 3 打开输入流
        FSDataInputStream fis = fs.open(path);
        // 4 创建输出流
        FileOutputStream fos = new FileOutputStream("d:/hadoop-2.7.2.tar.gz.part1");

        // 5 流对接
        byte[] buf = new byte[1024];
        for (int i = 0; i < 128 * 1024; i++) {
            fis.read(buf);
            fos.write(buf);
        }
        // 6 关闭流
        IOUtils.closeStream(fis);
        IOUtils.closeStream(fos);
    }

    @Test
    // 定位下载第二块内容
    public void readFileSeek2() throws Exception{

        // 1 创建配置信息对象
        Configuration configuration = new Configuration();

        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop101:8020"), configuration, "root");

        // 2 获取输入流路径
        Path path = new Path("/user/weichuang/input/hadoop-2.7.2.tar.gz");

        // 3 打开输入流
        FSDataInputStream fis = fs.open(path);

        // 4 创建输出流
        FileOutputStream fos = new FileOutputStream("d:/hadoop-2.7.2.tar.gz.part2");

        // 5 定位偏移量（第二块的首位）
        fis.seek(1024 * 1024 * 128);

        // 6 流对接
        IOUtils.copyBytes(fis, fos, configuration );

        // 7 关闭流
        IOUtils.closeStream(fis);
        IOUtils.closeStream(fos);
    }


}
