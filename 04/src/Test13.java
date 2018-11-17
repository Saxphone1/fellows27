/**
 * 1、普通代码块
 直接写在方法中的代码块就是普通代码块
 2、构造块是在类中定义的代码块  每次new一个对象 都会执行一次。
 3、在类中使用static声明的代码块称为静态代码块 只有第一次new的时候 执行一次

 静态代码块  优于  构造代码块  优于 构造方法执行
 * */
public class Test13 {
    public static void main(String[] args) {
        Student s =new Student();
//        Student s1 = new Student();
//        s.write();
    }
}
class Student{


    {
        System.out.println("我是构造代码块");
    }
    static {
        System.out.println("我是静态代码块");
    }

    public Student(){
        System.out.println("我是构造方法-----");
    }

    public void write(){
        {
            int i = 9;
            System.out.println("我是普通代码块");
        }

    }
}
