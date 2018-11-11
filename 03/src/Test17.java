import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//双色球案例
public class Test17 {
    public static void main(String[] args) {
        int[] redBalls = new int[33];
        int len = redBalls.length;
        for(int i=0;i<len;i++){
            redBalls[i] = i+1;
        }

        //用户选择的红球
        int[] userReds = new int[6];
        //用户选择的蓝球
        int userBlue = 0;
        //系统生成的中奖红球
        int[] sysReds = new int[6];
        //系统生成的中奖蓝球
        int sysBlue = 0;


        System.out.println("请选择（1，机选，2,人选）");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        Random r = new Random();
        switch (num){
            case 1:
                //机选
                computerSelection(redBalls,userReds);
                userBlue = r.nextInt(16) + 1;
//                System.out.println(Arrays.toString(userReds));
                break;
            case 2:
                //人选
                break;
        }
    }
    //随机在球池里面选择
    // balls --- 可选红球
    // redBalls  --- 选完的球存放位置
    public static void computerSelection(int[] balls,int[] redBalls){
        Random r = new Random();
        for(int i=0;i<redBalls.length;i++){
            int index = r.nextInt(balls.length - i);
            redBalls[i] = balls[index];
            balls[index] = balls[balls.length - 1- i];
        }
    }
}
