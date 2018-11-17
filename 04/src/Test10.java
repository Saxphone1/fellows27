public class Test10 {

    public static void main(String[] args) {
//        User u1 = new User("刘翔","china");
//        User u2 = new User("姚明","china");
//        User u3 = new User("李娜","china");

        User u1 = new User("刘翔");
        User u2 = new User("姚明");
        User u3 = new User("李娜");

        u1.print();
        u2.print();
        u3.print();
        System.out.println("----------------");
        u1.setCountry("US");
        u1.print();
        u2.print();
        u3.print();
        u1.say();
        User.say();


    }

}

class User{
    private String name;
    private static String country = "china";

//    public User(String name,String country){
//        this.name = name;
//        this.country = country;
//    }
public User(String name){
    this.name = name;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void print(){
        System.out.println(this.name+","+this.country);
    }

    public static void say(){
        eat();
        System.out.println("北京欢迎你");
    }

    public static void eat(){
        System.out.println("北京欢迎你111");
    }
}