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
        WeiboUtil.putContent("1001","nice!!!");
    }
}
