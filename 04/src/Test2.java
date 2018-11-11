public class Test2 {
    public static void main(String[] args) {

        Horse h1 = null;
        h1 = new Horse();
        h1.name="小白";
        h1.age = 4;

        Horse h2 = new Horse();
        h2.name= "小黑";

        h2 = h1;
        h2.name = "黑黑";

        System.out.println(h1.name);

//        Person p = new Person();
//        p = h1;

    }
}
class Horse{
    String name;
    int age;



}

