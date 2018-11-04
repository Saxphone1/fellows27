import java.util.Scanner;
public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入高：");
        int h = input.nextInt();
        System.out.print("请输入半径：");
        int r = input.nextInt();
        System.out.println("圆柱的体积为："+ 3.14 * r * r * h );
    }
}
