public class Test4 {
}


//懒汉式
class Singleton1{
    private Singleton1(){
        throw new RuntimeException("此类为单例模式，只能有一个实例对象");
    }
    private volatile static Singleton1 s;
    public static Singleton1 getSingleton(){
       if(s == null){//为单线程准备的
           synchronized (Singleton1.class){
               if(s == null){//为多线程准备的
                   s = new Singleton1();
               }
           }
       }
       return s;
    }
}
