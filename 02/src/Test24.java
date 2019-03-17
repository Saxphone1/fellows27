import java.util.Scanner;

/**
 *      *
 *      **
 *      ***
 *      ****
 *      *****
 * */
public class Test24 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        print(i);
    }

    public static void print(int num){
        for(int i=1;i<=num;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
