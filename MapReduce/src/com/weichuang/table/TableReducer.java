package com.weichuang.table;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableReducer extends Reducer<Text,TableBean,TableBean,NullWritable>{
    @Override
    protected void reduce(Text key, Iterable<TableBean> values, Context context) throws IOException, InterruptedException {
        String name = "";//小米、华为
        List<TableBean> beans =  new ArrayList<TableBean>();
        for (TableBean tb:values) {
            if("1".equals(tb.getFlag())){
                name = tb.getpName();
            }else{
                beans.add(tb);
            }
        }
        for(TableBean t:beans){
            t.setpName(name);
            context.write(t,NullWritable.get());
        }




    }
}
