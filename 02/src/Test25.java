/**
 *   乘法表
 * */
public class Test25 {

    public static void main(String[] args) {
        for(int i=1;i<=9;i++){//控制行
            for(int j=1;j<=i;j++){
                System.out.print(j+"*"+i+"="+j*i+"\t");
            }
            System.out.println();
        }
    }
}
