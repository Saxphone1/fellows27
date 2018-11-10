public class Test20 {
    //Java阶乘求和 1!+2!+...+10!
    public static void main(String[] args) {
       int i=1;
       int result = 0;
        do{
            int j=1;
            int num = 1;
            do{
                num*=j;
                j++;
            }while (j<=i);
            result += num;
            i++;
        }while (i<=10);
        System.out.println(result);
    }
}
