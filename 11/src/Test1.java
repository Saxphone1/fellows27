public class Test1 {
    public static void main(String[] args) {
        Dog dog = new Dog("小白",2,"red");
        Class dogClass = dog.getClass();

        Class dogClass1 = Dog.class;

        try {
            Class dogClass2 = Class.forName("Dog");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
