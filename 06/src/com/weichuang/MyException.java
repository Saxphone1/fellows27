package com.weichuang;

public class MyException extends RuntimeException{
    public MyException(){
        super();
    }
    public MyException(String str){
        super(str);
    }
}
