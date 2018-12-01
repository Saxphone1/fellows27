public class Test12 {
    public static void main(String[] args) {
//        IEat e1 =  new EatImpl();
//        e1.eat();
//
//        IEat e2 = new IEat(){
//            @Override
//            public void eat() {
//                System.out.println("eat...banana");
//            }
//        };
//        e2.eat();

        IEat e3 = (final String name,String fruit)->10;

        int result = e3.eat("zs","ydl");
        System.out.println(result);
        e3.say();
        e3.say11111();
        IEat.sing();
    }



}

interface IEat{
    public int eat(final String name,String fruit);
    public default void say(){
        System.out.println("ssssssssssss");
    }
    public default void say11111(){
        System.out.println("ssssssssssss");
    }
    public static void sing(){
        System.out.println("song.....");
    }
}

//class EatImpl implements IEat{
//
//    @Override
//    public void eat() {
//        System.out.println("eat...apple");
//    }
//}
