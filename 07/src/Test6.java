import java.util.Arrays;

public class Test6 {
    public static void main(String[] args) {
        int[] a1 = {1,2,42,23,2,1,12};
        Arrays.sort(a1);
        System.out.println(Arrays.toString(a1));

        String[] s1 = {"jkdfd","aeae","给各位","打扫"};
        Arrays.sort(s1);
        System.out.println(Arrays.toString(s1));

        Dog[] ds = {new Dog("ss",2),new Dog("小白",1),new Dog("嘿嘿",8)};
        Arrays.sort(ds);
        System.out.println(Arrays.toString(ds));

        Cat[] cs = {new Cat("ss",2),new Cat("小白",1),new Cat("嘿嘿",8)};
        Arrays.sort(cs,new CatComparator());
        System.out.println(Arrays.toString(cs));
    }
}
