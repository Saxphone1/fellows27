public class Test11 {
    public static void main(String[] args) {
        Person3 p = new Person3();
        p.print();
        Person3 p1 = new Person3();
        p.print();
        Person3 p2 = new Person3();
        p.print();
        Person3 p3 = new Person3();
        p.print();

    }
}

class Person3{
    private String name;
    public static int count = 0;
    public Person3(){
        count++;
    }
    public void print(){
        System.out.println(count);
    }

}
