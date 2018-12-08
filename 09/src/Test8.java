import java.util.LinkedList;
import java.util.Queue;

public class Test8 {
    public static void main(String[] args) {
        Queue<String> qu = new LinkedList<>();
        qu.add("aa");
        qu.add("bb");
        qu.add("cc");
        qu.forEach(System.out::println);
        System.out.println(qu.poll());
        System.out.println(qu.poll());
        System.out.println(qu.poll());
        System.out.println(qu.poll());
        System.out.println(qu.poll());
        System.out.println(qu.poll());

    }
}
