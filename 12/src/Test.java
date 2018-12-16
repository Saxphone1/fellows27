import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        List<String> l = new ArrayList<>();
//        l.add("String");
//        l.add("S1");
//        l.add("S2");
//
//        for (int i = 0; i <l.size() ; i++) {
//
//        }

//        Node<String> n1 = new Node<>("10");
//        System.out.println(n1.getData());
        Node<Number> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
//        n1 = n2;
//        getData(n2);
        getData2(n1);




    }

    public static void getData(Node<? extends Number> data) {
        System.out.println("data :" + data.getData());
    }

    public static void getData2(Node<? super Number> data) {
        System.out.println("data :" + data.getData());
    }

    public static List<String> fn(){
        return null;
    }

    public static <T> T[] func(T[] array,int i,int t){
        T temp = array[i];
        array[i] = array[t];
        array[t] = temp;
        return array;
    }
}
