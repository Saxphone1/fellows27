package com.weichuang.out;


import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;

public class MyFileRecordWriter extends RecordWriter<Text,NullWritable> {
    private FSDataOutputStream weichuangout = null;
    private FSDataOutputStream otherout = null;
    public MyFileRecordWriter(TaskAttemptContext context) throws IOException {
        FileSystem fs = FileSystem.get(context.getConfiguration());
        weichuangout = fs.create(new Path("d://output6/weichuang.txt"));
        otherout = fs.create(new Path("d://output6/other.txt"));
    }

    @Override
    public void write(Text text, NullWritable nullWritable) throws IOException, InterruptedException {
        //http://www.google.com
        String s = text.toString();
        if(s.contains("weichuang")){
            weichuangout.write(s.getBytes());
        }else{
            otherout.write(s.getBytes());
        }
    }

    @Override
    public void close(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        weichuangout.close();
        otherout.close();
    }
}
