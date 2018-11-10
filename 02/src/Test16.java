/**
 * 计算1-100之间所有整数之和。5050
 * */
public class Test16 {
    public static void main(String[] args) {
        int i=1;
        int num = 0;
        while(i<=100){
            num += i;
            i++;
        }
        System.out.println(num);
    }
}
