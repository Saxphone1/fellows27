package com.weibo;

import java.io.IOException;

public class Weibo {
    public static void init() throws IOException {
//        WeiboUtil.createNameSpace("weibo");
//        WeiboUtil.createTable("weibo:content",1,"info");
//        WeiboUtil.createTable("weibo:users",1,"attends","fans");
//        WeiboUtil.createTable("weibo:inbox",2,"info");

    }
    public static void main(String[] args) throws IOException {
        init();
//        WeiboUtil.putContent("A","nice!!!");
//        WeiboUtil.putContent("D","D1!!!");
//        WeiboUtil.putContent("E","E1!!!");
//        WeiboUtil.putContent("F","F!!!");
//        WeiboUtil.putContent("D","D2!!!");
//        WeiboUtil.putContent("D","D3!!!");
//        WeiboUtil.attendUser("A","E");
//        WeiboUtil.attendUser("A","F");
//        WeiboUtil.putContent("C","C1111111!!!");
        WeiboUtil.removeUser("A","E");
    }
}
