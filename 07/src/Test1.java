public class Test1 {
    public static void main(String[] args) {
        String s1 = "飞飞";
        //下面的语句创建了几个对象
        String s2 = new String("飞飞");
        String s3 = "飞飞";
        System.out.println(s1 == s3);
        System.out.println("---------------");

        // 编译期可确定的值，用已有的值，编译期不能确定，创建一个新的对象
        String a = "a";
        String a1 = a + "1";
        String a2 = "a1";
        System.out.println(a1 == a2);

        final String b = "b";
        String b1 = b + 1;
        String b2 = "b1";
        System.out.println(b1 == b2);

        String c = getC();
        String c1 = c +1;
        String c2 = "c1";
        System.out.println(c1 == c2);

        final String d = getD();
        String d1 = d +1;
        String d2 = "d1";
        System.out.println(d1 == d2);

    }
    public static String getC(){
        return "c";
    }
    public static String getD(){
        return "d";
    }
}
