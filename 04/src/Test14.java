/**
 *1、构造方法私有化
  2、声明一个本类对象
  3、给外部提供一个静态方法获取对象实例

 * */
public class Test14 {
    public static void main(String[] args) {
        Singleton1 s1 = Singleton1.getSingleton();
        Singleton1 s2 = Singleton1.getSingleton();
        s1.print();
        s2.print();
        System.out.println(s1 == s2);
    }
}

//饿汉式
class Singleton{
    private Singleton(){}
    private static Singleton s = new Singleton();
    public static Singleton getSingleton(){
        return s;
    }
    public void print(){
        System.out.println("单例模式");
    }
}
//懒汉式
class Singleton1{
    private Singleton1(){}
    private static Singleton1 s;
    public static Singleton1 getSingleton(){
        if(s == null){
            s = new Singleton1();
        }
        return s;
    }
    public void print(){
        System.out.println("单例模式");
    }
}

