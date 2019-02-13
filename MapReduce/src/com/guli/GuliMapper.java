package com.guli;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.hsqldb.lib.StringUtil;

import java.io.IOException;

public class GuliMapper extends Mapper<LongWritable,Text,Text,NullWritable>{
    private Text t = new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();

        String str = ETLUTil.EtlStr(line);
        if(StringUtils.isBlank(str)) return;
        t.set(str);
        context.write(t,NullWritable.get());
    }
}
