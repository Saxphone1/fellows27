import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        String str = "dfafd45246sba2fd323asf";
        System.out.println(str.charAt(1));
        System.out.println(Arrays.toString(str.toCharArray()));
        char[] cs = {'1','4','6'};
        String s1 = new String(cs,0,2);
        System.out.println(str.startsWith("dfa",4));
        System.out.println(str.replace("fd","*"));
        System.out.println(str.replaceAll("\\d","*"));
        System.out.println(str.substring(4));
        System.out.println(str.substring(4,7));
        System.out.println(str.indexOf("a"));
        System.out.println(Arrays.toString(str.split("s",2)));
        System.out.println(str.indexOf("adasdfd"));
        String s3 = "   d    fdfd fdfd       ";
        System.out.println(s3.trim());



    }
}
