import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) {
//        String s = "5201314";
////        boolean matches = s.matches("\\d+");
////        String s1 = s.replaceAll("1", "2");
//        String[] split = s.split("1",3);
//        System.out.println(Arrays.toString(split));


//        Pattern p = Pattern.compile("\\d+");
//        Matcher m = p.matcher(s);
//        boolean b = m.matches();
//        System.out.println(b);

//        char[] chars = s.toCharArray();
//        boolean flag = true;
//        for (int i = 0; i <chars.length ; i++) {
//            if(chars[i] < '0' || chars[i] > '9'){
//                flag = false;
//                break;
//            }
//        }
//        System.out.println(flag);

//        Pattern p = Pattern.compile("[a-zA-Z0-9_]c");
        Pattern p = Pattern.compile("^a*b$");
        Matcher m = p.matcher("aaaab");
        boolean b = m.matches();

        System.out.println(b);
    }
}
