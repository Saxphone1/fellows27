package com.proxy;

public class Test {
    public static void main(String[] args) {
        Person person =  new Person();
        ProxyBuy pb = new ProxyBuy();
//        IShoping shoping = (IShoping)pb.create(person);
//        shoping.buy();//invoke

        IHotel ih = (IHotel)pb.create(person);
        ih.book();

    }
}
