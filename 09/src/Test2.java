import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test2 {
    public static void main(String[] args) {
//        hashSet1();
//        treeSet();
        linkedHashSet();
    }
    public static void linkedHashSet(){
        Set<String> set = new LinkedHashSet<>();
        set.add("tom");
        set.add("james");
        set.add("jack");
        set.add("lose");
        set.add("lily");

        String[] cs = set.toArray(new String[]{});
        for (String c:cs) {
            System.out.println(c);
        }
    }
    public static void treeSet(){
//        TreeSet<String> set = new TreeSet<>();
//
//        set.add("tom");
//        set.add("james");
//        set.add("jack");
//        set.add("lose");
//        set.add("lily");
//
//        String[] str = set.toArray(new String[]{});
//        for (String s:str) {
//            System.out.println(s);
//        }
        Set<Cat> set = new TreeSet<>(new CatComp());
        Cat c1 = new Cat(1,3,"miaomiao");
        Cat c2 = new Cat(2,4,"huahua");
        Cat c3 = new Cat(3,2,"xiaobai");
        Cat c4 = new Cat(1,3,"xiaohei");
        set.add(c1);
        set.add(c2);
        set.add(c3);
        set.add(c4);

        Cat[] cs = set.toArray(new Cat[]{});
        for (Cat c:cs) {
            System.out.println(c);
        }


    }
    public static void hashSet1(){
        Set<Cat> set = new HashSet<>();
        Cat c1 = new Cat(1,3,"miaomiao");
        Cat c2 = new Cat(2,4,"huahua");
        Cat c3 = new Cat(3,2,"xiaobai");
        Cat c4 = new Cat(1,3,"miaomiao");
        set.add(c1);
        set.add(c2);
        set.add(c3);
        set.add(c4);

        Cat[] cs = set.toArray(new Cat[]{});
        for (Cat c:cs) {
            System.out.println(c);
        }

        System.out.println(c1.hashCode()%16);
        System.out.println(c2.hashCode()%16);
        System.out.println(c3.hashCode()%16);
        System.out.println(c4.hashCode()%16);



    }
    public static void hashSet(){
        Set<String> set = new HashSet<>();

        set.add("Tom");
        set.add("jack");
        set.add("james");
        set.add("lose");
        set.add("lily");
        set.add("lily");
//        set.remove("jack");
        System.out.println(set.size());
        String[] str = set.toArray(new String[]{});
        for (String s:str) {
            System.out.println(s);
        }



    }
}
