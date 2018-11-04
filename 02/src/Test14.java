import java.util.Scanner;

public class Test14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int d = input.nextInt();
        switch(d){
            case 1:
                System.out.println("星期一");
                break;
            case 2:
//                System.out.println();
                System.out.println("星期2");
                break;
            case 3:
                System.out.println("星期3");
                break;
            case 4:
                System.out.println("星期4");
                break;
            case 5:
                System.out.println("星期5");
                break;
            case 6:
                System.out.println("星期6");
                break;
            default:
                System.out.println("星期日");
        }
    }
}
