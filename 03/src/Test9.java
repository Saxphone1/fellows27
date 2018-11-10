
public class Test9 {

    public static void main(String[] args) {

        int[][] sorce = {{45,78,98}, {59,80,76},{54,75,87}};

        for(int i=0;i<3;i++){
            int num = 0;
            for(int j=0;j<3;j++){
                num += sorce[i][j];
            }
            System.out.println("第"+(i+1)+"个班的平均分："+num/3);

        }


    }

    /**
     *      {
     *          {45,78,98},
     *          {59,80,76},
     *          {54,75,87}
     *      }
     *
     *
     *
     * */
}
