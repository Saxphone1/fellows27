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
        //表示红球选中数
        int selectionRedNum = 0;
        //表示蓝球选中数
        int selectionBlueNum = 0;


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
                System.out.println("请输入6个红球(1~33)");
                for(int i=0;i<userReds.length;i++){
                    userReds[i] = input.nextInt();
                }
                System.out.println("请输入1个蓝球(1~16)");
                userBlue = input.nextInt();
                break;
        }

        computerSelection(redBalls,sysReds);
        sysBlue = r.nextInt(16)+1;

        for(int i=0;i<6;i++){
            int sysLen = sysReds.length - selectionRedNum;
            for(int j=0;j<sysLen;j++){
                if(userReds[i] == sysReds[j]){
                    int temp = sysReds[j];
                    sysReds[j] = sysReds[sysLen-1];
                    sysReds[sysLen-1] = temp;
                    selectionRedNum++;
                    break;
                }
            }
        }

        if(userBlue == sysBlue){
            selectionBlueNum++;
        }
        Arrays.sort(userReds);
        Arrays.sort(sysReds);

        System.out.println(Arrays.toString(userReds)+"+"+userBlue);
        System.out.println(Arrays.toString(sysReds)+"+"+sysBlue);

        if(selectionRedNum <=3 && selectionBlueNum==0){
            System.out.println("别伤心，没中很正常");
        }else if(selectionBlueNum == 1 && selectionRedNum < 3){
            System.out.println("恭喜六等奖，5元到手");
        }else if((selectionRedNum==3&& selectionBlueNum==1) || (selectionRedNum==4&& selectionBlueNum==0)){
            System.out.println("恭喜五等奖，10元到手");
        }else if((selectionRedNum==4&& selectionBlueNum==1) || (selectionRedNum==5&& selectionBlueNum==0)){
            System.out.println("恭喜四等奖，200元到手");
        }else if(selectionRedNum==5&& selectionBlueNum==1){
            System.out.println("恭喜三等奖，3000元到手");
        }else if(selectionRedNum==6&& selectionBlueNum==0){
            System.out.println("恭喜二等奖，1万元到手");
        }else if(selectionRedNum==6&& selectionBlueNum==1){
            System.out.println("恭喜一等奖，500万元到手");
        }else{
            System.out.println("系统异常，2元不退");
        }









        // 4 7 8 11 22 33

        // 1 2 3 6 5      4         1





    }
    //随机在球池里面选择
    // balls --- 可选红球
    // redBalls  --- 选完的球存放位置
    public static void computerSelection(int[] balls,int[] redBalls){
        Random r = new Random();
        for(int i=0;i<redBalls.length;i++){
            int index = r.nextInt(balls.length - i);
            redBalls[i] = balls[index];
            int temp = balls[index];
            balls[index] = balls[balls.length - 1- i];
            balls[balls.length - 1- i] = temp;
        }
    }
}
