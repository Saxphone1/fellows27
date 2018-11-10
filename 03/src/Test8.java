
public class Test8 {

    public static void main(String[] args) {
        char[] c = {'A','B','C','D','E','F','G'};
        for(int i=1;i<=7;i++){//控制行
            for(int j=7;j>=i;j--){
                System.out.print(" ");
            }
            for(int k=1;k<=2* i-1;k++){
                System.out.print(c[i-1]);
            }
            System.out.println();
        }

        // 1 3 5 7 9
    }
}
