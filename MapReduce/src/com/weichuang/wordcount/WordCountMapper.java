package com.weichuang.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        Text t = new Text();
        IntWritable i = new IntWritable(1);
        //1 读取文件内容
        String line = value.toString();
        //2 按空格分隔内容
        String[] words = line.split(" ");
        //3 输出到缓存区
        for (String w:words) {
            t.set(w);
            context.write(t,i);
        }

    }
}
