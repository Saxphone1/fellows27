package com.weichuang;

public class ConcreteIterator implements Iterator{

    private MyList list =  null;
    private int index;
    public ConcreteIterator(MyList list){
        this.list = list;
    }
    public boolean hasNext(){
        if(index>=list.getSize()){
            return false;
        }else{
            return true;
        }
    }
    public Object next(){
        Object obj = list.get(index);
        index++;
        return obj;
    }

}
