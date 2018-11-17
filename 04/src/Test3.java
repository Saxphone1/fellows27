public class Test3 {
    public static void main(String[] args) {
        Person1 p1 = new Person1();
//        p1.name="zs";
        p1.setName("zs");
//        p1.age = 18;
        System.out.println(p1.getName());
        p1.say();
    }
}

class Person1{
    //成员变量
    private String name;//private是修饰符，代表私有
    private int age;

    public void setName(String name){
        this.name = name;//this 指向方法的调用者
    }
    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;//this 指向方法的调用者
    }
    public int getAge(){
        return this.age;
    }

    void say(){
        System.out.println("我叫"+Person1.this.name+",我"+age+"岁");
    }

}
