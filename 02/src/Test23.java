public class Test23 {
    //输出10个斐波那契（Fibonacci）数列：1 1 2 3 5 8 13 21 34 55
    public static void main(String[] args) {
        int n1 = 1;
        int n2 = 1;
        System.out.print(n1 +" "+ n2);
        for(int i=3;i<=10;i++){
            int next = n1 + n2;
            System.out.print(" "+next);
            n1 = n2;
            n2 = next;
        }
    }
}
