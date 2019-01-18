package com.weichuang.newtable.table;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TableMapper extends Mapper<LongWritable,Text,TableBean,NullWritable>{
    Map<String, String> pdMap = new HashMap<>();


    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        // 1 获取缓存的文件
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("pd.txt")));
//        pdMap.put("01","xiaomi");
//        pdMap.put("02","huawei");
        String line;
        while(StringUtils.isNotEmpty(line = reader.readLine())){
            // 2 切割
            String[] fields = line.split("\t");

            // 3 缓存数据到集合
            pdMap.put(fields[0], fields[1]);
        }

        // 4 关流
        reader.close();
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();
        TableBean tb = new TableBean();
        String[] words = line.split("\t");
        // 1001 01 1
        tb.setOrderId(words[0]);
        tb.setAmount(Integer.parseInt(words[2]));
//        pdMap.get(words[1]);//xiaomi
        tb.setpName(pdMap.get(words[1]));
        tb.setFlag("0");
        tb.setpId(words[1]);

        context.write(tb,NullWritable.get());


    }
}
