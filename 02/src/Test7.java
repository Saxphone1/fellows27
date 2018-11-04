public class Test7 {
    public static void main(String[] args) {
        //交换两个数
        int a = 1005;
        int b = 2;
        //....
//        int c = a;
//        a = b;
//        b = c;

//        a = a + b;// 3
//        b = a - b; // 1
//        a = a - b; // 2

        a = a + b - (b=a);


        System.out.println(a);
        System.out.println(b);



    }
}
