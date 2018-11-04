import java.util.Scanner;

public class Test11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int s = input.nextInt();
        if(s >= 90){
            System.out.println("A");
        }else if(s <90 && s>=80){
            System.out.println("B");
        }else if(s <80 && s>=70){
            System.out.println("C");
        }else if(s <70 && s>=60){
            System.out.println("D");
        }else{
            System.out.println("E");
        }
    }
}
