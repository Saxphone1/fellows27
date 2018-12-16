package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBuy implements InvocationHandler {
    private Object target;//被代理对象
    //创建代理对象
    public Object create(Object target){
        this.target = target;
        Object object = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
        return object;
    }

    /**
     * proxy: 代理对象
     * method： 被代理对象的方法
     * args： 方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("查询product");
        method.invoke(target);
        System.out.println("product已订");

        return null;
    }
}
