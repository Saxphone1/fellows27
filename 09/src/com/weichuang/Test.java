package com.weichuang;

public class Test {
    public static void main(String[] args) {
        MyList list = new ConcreteAggregate();
        //List<String> l = new ArrayList<>();
        list.add("刘备");
        list.add("张飞");
        list.add("关羽");
        list.add("曹操");
        list.add("诸葛亮");
        //l.iterator();
        Iterator iter = list.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}
