package com.weichuang;

import java.io.*;

public class IO {
    public static void out() throws IOException {
        // 1 确定文件
        File file = new File("d://xiyou.txt");
        // 2. 创建一个输出流
        OutputStream outs = new FileOutputStream(file,true);
        //3 定义一个输出内容
        String str = "小伙伴27 最nb";
        //4 写入文件
        outs.write(str.getBytes());
        // 5 关闭流
        outs.close();
    }

    public static void in() throws IOException {
        // 1 确定文件
        File file = new File("d://xiyou.txt");
        //2 创建一个输入流
        InputStream ins = new FileInputStream(file);
        StringBuilder sb = new StringBuilder();
        byte[] bytes = new byte[1024];

        while (ins.read(bytes)!= -1){
            sb.append(new String(bytes));
        }
        System.out.println(sb);
        //关闭流
        ins.close();

    }

    public static void main(String[] args) throws IOException {
        out();
        in();
    }
}
