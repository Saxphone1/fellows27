package com.guli;

public class ETLUTil {
    public static String  EtlStr(String s1){
        String[] words = s1.split("\t");
        //小于9个为无效数据
        if(words.length <9){
            return null;
        }
        //把视频类别中的空格去掉
        words[3] = words[3].replaceAll(" ","");
        //把相关视频字段加一起
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<words.length;i++){
            if(i < 9){
                sb.append(words[i]).append("\t");
            }else{
                if(i == words.length -1){
                    sb.append(words[i]);
                }else{
                    sb.append(words[i]).append("&");
                }

            }
        }

        return sb.toString();
    }
}
