package com.weichuang;

public class User extends UserService{
    public void login(UserBean userBean) {

        if(!"admin".equals(userBean.getName())){
            throw new MyException("用户名错误");

        }
        if(!"1234".equals(userBean.getPwd())){
            throw new MyException("密码错误");
        }
        System.out.println("登录成功");
        System.out.println(userBean);
    }
}
