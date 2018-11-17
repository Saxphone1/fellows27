public class Test1 {
    public static void main(String[] args) {
        Person p1 = new Person();
//        Person p2 = new Person();

        Person p3;
        p1.name="zhangsan";
        p1.eat();

        p1 =  null;//GC

        new Person().eat();//匿名对象

    }
}

class Person{
    String name;
    int age;
    void eat(){
        System.out.println(name+"吃的很多。。。。"+age);
    }
}
