import java.util.Scanner;

public class Test8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int s = input.nextInt();
        System.out.println(s >= 60?"及格":"重修");

        int i = 7> 9? 3:4;
        System.out.println(i);
    }
}
