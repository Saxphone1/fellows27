import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Random r = new Random();
        for(int i=0;i<arr.length;i++){
            arr[i] = r.nextInt(20);
        }
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        boolean flag = false;
        for(int i=0;i<arr.length;i++){
            if(x == arr[i]){
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("你赢了");
        }else{
            System.out.println("你输了");
        }
        System.out.println(Arrays.toString(arr));
    }
}
