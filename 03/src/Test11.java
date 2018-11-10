import java.util.Arrays;

public class Test11 {
    public static void main(String[] args) {
        int[] arr = {44,78,34,56,12};
        int len = arr.length;
        for(int i=0;i<len;i++){//控制的轮数
            for(int j=i+1;j<len;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //  44 78 34 56 12
    //  12 78 44 56 34   第一轮
    //  12 34 78 56 44   第二轮
    //  12 34 44 78 56   第三轮
    //  12 34 44 56 78   第四轮

}
