package com.weichuang;
/**
 *  自定义异常
 *  1. 继承 Throwable
 *  2. 继承 Exception
 *  3. 继承 RunTimeException
 *
 * */
public class Test3 {
    public static void main(String[] args) {
        User u = new User();
        UserBean ub = new UserBean();
        ub.setName("admin");
        ub.setPwd("1234");
        try{
            u.login(ub);
        }catch (MyException e){
            System.out.println("sssss");
        }
    }
}
