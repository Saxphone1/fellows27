/**
 *  在创建一个子类的时候，会执行父类的构造方法，如果父类没有默认构造方法，
 *  子类的构造方法里面就需要显示的调用父类有参数的构造方法
 *
 * */
public class Test1 {
    public static void main(String[] args) {
        HomeDog hd = new HomeDog();
        HuskyDog hy =  new HuskyDog();
        hd.print();
        hd.eat();
        hy.eat();
        hd.fn(2);
    }
}
class Cat{

}
class Dog{
    protected String name;
    protected String sex;
    public Dog(String name){
        this.name= name;
        System.out.println("Dog的构造方法");
    }
    public void eat(){
        System.out.println("吃饭");
    }
}
class HomeDog extends Dog{

    public HomeDog(){
        super("jiagou");
        System.out.println("我是homedog的构造方法");
    }
    public void fn(final int size){
//        size++;
        System.out.println(size);
    }

    public void print(){
        System.out.println(super.name+"...家狗");
    }

    public void eat(){
        super.eat();
        System.out.println("我爱吃骨头");
    }
}
class HuskyDog extends Dog{

    public HuskyDog(){
        super("哈士奇");
    }
    public void show(){
        System.out.println("我会跳舞");
    }

    public void eat() {
        System.out.println("我爱吃鸡肝");
    }
}

