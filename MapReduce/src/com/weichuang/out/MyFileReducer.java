package com.weichuang.out;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MyFileReducer extends Reducer<Text,NullWritable,Text,NullWritable>{
    @Override
    protected void reduce(Text key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        String v = key.toString();

        context.write(new Text( v+"\r\n"),NullWritable.get());
    }
}
