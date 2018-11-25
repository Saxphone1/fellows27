package com.weichuang;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(div(10,2));

    }
    public static int div(int a,int b){
        try{
            int[] arr = {1,2,3,4};
            int c = a/b;
            System.out.println(arr.length);
            System.out.println("测试。。");
            return c;
        }catch (NullPointerException e){
            System.out.println("空指针");
        }catch (ArithmeticException e){
            System.out.println("除数不能为0");
        }catch (Exception e){
            System.out.println("异常");
        }finally {
            System.out.println("...................");
            return 2;
        }
    }
    //面试题：  finally 和 return  谁先执行




}
