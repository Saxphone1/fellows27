package com.weichuang;

public class Test4 {
}

interface IPerson{
    public void eat();
    public void swim();
    public void run();
    public void sing();
}
abstract class Adp implements IPerson{
    public void eat(){}
    public void swim(){}
    public void run(){}
    public void sing(){}
}

class Man extends Adp{
    public void sing(){

    }
    public void run(){}
}
class Woman implements IPerson{
    public void eat(){}
    public void swim(){

    }
    public void run(){}
    public void sing(){}
}
