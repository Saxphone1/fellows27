/**
 *   乘法表
 * */
public class Test27 {

    public static void main(String[] args) {

        for(int i=1;i<=5;i++){//控制行
            for(int j=5;j>=i;j--){
                 System.out.print(" ");
            }
            for(int k=1;k<=2* i-1;k++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 1 3 5 7 9
    }
}
