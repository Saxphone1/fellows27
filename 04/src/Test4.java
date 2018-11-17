/**
 * 构造方法是在类中定义的，构造方法的定义格式：方法名称与类名称相同，无返回值类型的声明。
 * 1.类自带一个默认的无参数的构造方法
 * 2.如果自己声明了一个构造方法，默认构造方法就没有了
 * */
public class Test4 {
    public static void main(String[] args) {
//        Dog d1 = new Dog("wangcai",20);
//        Dog d2 = new Dog("xiaocai",2);
        Dog d1 = new Dog("wangcai",20);
        d1.print();
    }
}

class Dog{
    private String name;
    private int age;

    public Dog(){}

    public Dog(String name){
        this.name = name;
        System.out.println("我是一个参数的构造方法");
    }

    public Dog(String name,int age){
        this(name);
        this.age = age;
        System.out.println("我是两个参数的构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void print(){
        System.out.println("我叫"+this.name+"我"+this.age+"岁");
        this.eat();
    }

    public void eat(){

    }
}
