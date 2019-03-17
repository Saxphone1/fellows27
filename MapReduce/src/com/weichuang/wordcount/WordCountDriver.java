package com.weichuang.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WordCountDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //1 获取Job
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        // 2 设置指定本程序的jar包所在的本地路径
        job.setJarByClass(WordCountDriver.class);
        //3 设置map 和 reducer的类
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);
        //4 设置 map的输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        //5 设置 reducer的输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        //6 设置输入输出路径
        job.setCombinerClass(WordCountReducer.class);
        job.setInputFormatClass(CombineTextInputFormat.class);
        CombineTextInputFormat.setMaxInputSplitSize(job, 4194304);// 4m
        CombineTextInputFormat.setMinInputSplitSize(job, 2097152);// 2m

        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));
        //7 提交
        boolean result = job.waitForCompletion(true);
        System.exit(result?0:1);

    }
}
