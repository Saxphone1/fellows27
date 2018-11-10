public class Test2 {
    public static void main(String[] args) {
        short a =1;
        print(a);
    }

//    public static void print(int a){
//        System.out.println(a);
//        System.out.println("-------");
//    }

    public static void print(long a){//方法名相同，参数类型不同
        System.out.println(a);
        System.out.println("==========");
    }
    public static void print(int a,int b){//方法名相同，参数个数不同
        System.out.println(a);
        System.out.println(b);
        System.out.println("++++++++");
    }
}
