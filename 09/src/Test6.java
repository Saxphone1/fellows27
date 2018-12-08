import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Test6 {
    public static void main(String[] args) {
        List<String> v = new Vector<>();
        v.add("Tom");
        v.add("jack");
        v.add("lose");
        v.add("lily");
        v.add("lily");
        Collections.replaceAll(v,"lily", "lose");
        Collections.addAll(v,"aa","bb");

        for(int i=0;i<v.size();i++){
            System.out.println(v.get(i));
        }

    }
}
