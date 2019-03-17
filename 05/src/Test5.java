public class Test5 {
    public static void main(String[] args) {
        Girl g =  new Girl();
        g.eat();
//        g.print();
    }
}
interface IEat{
//    public abstract void eat();
    void eat();
//    public static final int NUM = 10;
    int NUM = 10;
}
interface ISleep extends IEat{
    void sleep();
//    public default void print(){
//        System.out.println("print.....");
//    }
}

interface IRun extends IEat,ISleep{
    void run();
}

class Girl implements IRun,IEat{
    public void run(){
        System.out.println("run...");
    }
    public void sleep(){
        System.out.println("sleep...");
    }
    public void eat(){
        System.out.println("eat...");
    }
}

