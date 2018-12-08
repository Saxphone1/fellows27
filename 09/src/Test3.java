import java.util.*;
import java.util.function.Consumer;

public class Test3 {
    public static void main(String[] args) {
        Vector<String> v = new Vector<>();
        v.add("Tom");
        v.add("jack");
        v.add("lose");
        v.add("lily");
//        iterator(v);
//        enumeration(v);
        foreach1(v);
    }
    public static void foreach1(Collection<String> c){

//        Consumer<String> cc = (String str)->{
//            System.out.println(str);
//        };

        c.forEach(str-> System.out.println(str));
//        c.forEach(System.out::println);
    }

    public static void foreach(Collection<String> c){
        for(String s:c){
            System.out.println(s);
        }
    }

    public static void enumeration(Vector<String> v){
        Enumeration<String> e = v.elements();
        while (e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
    }


    public static void iterator(Collection<String> c){
        Iterator<String> it = c.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
