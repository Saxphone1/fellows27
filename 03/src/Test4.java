public class Test4 {
    public static void main(String[] args) {
        print(1,2,3,4,5);
    }

    public static void print(int b,int... a){//可变参数必须放到参数的最后一个
        //可变参数当做数组使用
        for (int x:a) {
            System.out.println(x);
        }
    }
}
