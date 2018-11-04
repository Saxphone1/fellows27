import java.util.Scanner;

public class Test15 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int i1 = input.nextInt();
        int i2 = input.nextInt();
        String op = input.next();
        switch(op){
            case "+":
                System.out.println(i1 + i2);
                break;
            case "-":
                System.out.println(i1 - i2);
                break;
            case "*":
                System.out.println(i1 * i2);
                break;
            case "/":
                if(i2 == 0){
                    System.out.println("除数不能为0");
                }else{
                    System.out.println(i1 / i2);
                }
                break;
        }
    }
}
