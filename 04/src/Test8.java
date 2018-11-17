public class Test8{
    public static void main(String[] args){
        Person2 p  = new Person2();
        method(p) ;
        System.out.println("person name= "+p.name) ;
    }
    public static void method(Person2 p ){
        p.name = "备备";
    }
}
class Person2{
    String name = "飞飞";   //省略封装
}
