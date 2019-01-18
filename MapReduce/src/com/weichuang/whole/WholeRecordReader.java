package com.weichuang.whole;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class WholeRecordReader extends RecordReader<NullWritable, BytesWritable> {
    private BytesWritable values = new BytesWritable();
    private FileSplit inputSplit;
    private Configuration conf;
    private boolean isF = false;

    @Override
    public void initialize(InputSplit inputSplit, TaskAttemptContext context) throws IOException, InterruptedException {
        this.inputSplit = (FileSplit)inputSplit;
        this.conf = context.getConfiguration();
    }

    @Override
    public boolean nextKeyValue() throws IOException, InterruptedException {

        if(!isF){
            //获取文件系统
            FileSystem fs = FileSystem.get(conf);
            //文件来源路径
            Path path = this.inputSplit.getPath();
            //创建一个输入流
            FSDataInputStream input = fs.open(path);
            //每次获取长度
            byte[] bytes = new byte[(int)inputSplit.getLength()];
            //读内容到bytes数组
            IOUtils.readFully(input,bytes,0,(int)inputSplit.getLength());
            //把内容放到输出字段values中
            this.values.set(bytes,0,bytes.length);

            IOUtils.closeStream(input);
            isF = true;
            return true;

        }

        return false;
    }

    @Override
    public NullWritable getCurrentKey() throws IOException, InterruptedException {
        return NullWritable.get();
    }

    @Override
    public BytesWritable getCurrentValue() throws IOException, InterruptedException {
        return this.values;
    }

    @Override
    public float getProgress() throws IOException, InterruptedException {
        return isF?1:0;
    }

    @Override
    public void close() throws IOException {

    }
}
