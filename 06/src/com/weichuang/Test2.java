package com.weichuang;

public class Test2 {
    public static void main(String[] args) {
        try{
            int i= 10;
            div(10,1);

        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
    //throws 可能会抛出的异常
    public static void div(int a,int b)throws ArithmeticException{
            if(b == 1){
                // 人为抛出异常，可以写在任何位置
                throw new NullPointerException("除数为1，没有意义");
            }
            int c = a/b;
            System.out.println("测试。。");


    }
}
