public class Test4 {
    public static void main(String[] args) {
        Man m = new Man();
        m.eat();
        m.move();
        Woman w = new Woman();
        w.eat();
        w.move();

    }
}
abstract class Animal{
    public abstract void move();
}

abstract class Person extends Animal{
    public String name;
    public abstract void eat();
}
class Man extends Person{
    public void eat(){
        System.out.println("我爱吃肉");
    }
    public void move(){
        System.out.println("我爱跑步");
    }
}
class Woman extends Person{
    public void eat(){
        System.out.println("我爱吃素");
    }
    public void move(){
        System.out.println("我爱逛街");
    }
}
