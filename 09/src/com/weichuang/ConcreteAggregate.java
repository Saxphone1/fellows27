package com.weichuang;

public class ConcreteAggregate implements MyList{
    private Object[] elements;
    private int size;
    private int index;
    public ConcreteAggregate(){
        elements = new Object[100];
    }

    public void add(Object e){
        elements[index++] = e;
        size++;
    }
    public Object get(int index){
        return elements[index];
    }
    public Iterator iterator(){
        return new ConcreteIterator(this);
    }
    public int getSize(){
        return size;
    }

}
