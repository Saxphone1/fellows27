import java.util.Scanner;

public class Test9 {
    public static void main(String[] args) {
//        char c = 'c';
        Scanner input =  new Scanner(System.in);
        char c = input.next().charAt(0);
        if(c >= 65 && c<=90){
            System.out.println("大写字母");
        }else{
            System.out.println("小写字母");
        }

    }
}
