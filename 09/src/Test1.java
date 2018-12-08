import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Test1 {
    public static void main(String[] args) {
//        vector();
        linkedList();
    }
    public static void linkedList(){
        LinkedList<String> l = new LinkedList<>();
        l.add("Tom");
        l.add("jack");
        l.add("lose");
        l.add("lily");

        for(int i=0;i<l.size();i++){
            System.out.println(l.get(i));
        }
    }
    public static void vector(){
        List<String> v = new Vector<>();
        v.add("Tom");
        v.add("jack");
        v.add("lose");
        v.add("lily");

        for(int i=0;i<v.size();i++){
            System.out.println(v.get(i));
        }
    }

    public static void arrayList(){
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("jack");
        list.add("lose");
        list.add("lily");

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
}
