package com.proxy;

public class Person implements IHotel{
    @Override
    public void book() {
        System.out.println("订酒店");
    }
//    @Override
//    public void buy() {
//        System.out.println("已付款");
//    }

}
