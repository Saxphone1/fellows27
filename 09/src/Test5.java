import java.util.*;

public class Test5 {
    public static void main(String[] args) {
//        hashMap();
        treeMap();
    }
    public static void treeMap() {
        Map<Integer, String> map = new TreeMap<>();
        map.put(2, "tom2");
        map.put(1, "tom");
        map.put(4, "tom4");
        map.put(3, "tom3");
//        map.forEach((k,v)->{
//            System.out.println(k +"->"+v);
//        });

    }
    public static void linkedhashmap() {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "tom");
        map.put(2, "tom2");
        map.put(3, "tom3");
        map.put(4, "tom4");
//        map.forEach((k,v)->{
//            System.out.println(k +"->"+v);
//        });

    }

    public static void hashtable() {
        Map<Integer, String> map = new Hashtable<>();
        map.put(1, "tom");
        map.put(2, "tom2");
        map.put(3, "tom3");
        map.put(4, "tom4");
        System.out.println(map.get(3));
    }

    public static void hashMap(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"tom");
        map.put(2,"tom2");
        map.put(3,"tom3");
        map.put(4,"tom4");
        System.out.println(map.get(3));
        //获取key value 对
        Set<Map.Entry<Integer,String>> entrySet= map.entrySet();
        for(Map.Entry e:entrySet){
            System.out.println(e.getKey()+"->"+e.getValue());
        }
        //获取key
        Set<Integer> set = map.keySet();
//        set.forEach(System.out::println);

        //获取value
        Collection<String> c = map.values();
//        c.forEach(System.out::println);
//
//        map.forEach((k,v)->{
//            System.out.println(k +"->"+v);
//        });
//


    }
}
