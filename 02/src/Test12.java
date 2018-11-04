import java.util.Scanner;

public class Test12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i1 = input.nextInt();
        int i2 = input.nextInt();

        if(i1 > i2){
            System.out.println("i1大");
        }else if(i1 < i2){
            System.out.println("i2大");
        }else{
            System.out.println("一样大");
        }
    }
}
