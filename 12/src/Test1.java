import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        Map<String,String> m = new HashMap<>();
        m.put("1","100");
        m.put("2","200");

        Set<Map.Entry<String, String>> entries = m.entrySet();

    }
}
