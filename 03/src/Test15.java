import java.util.Arrays;

public class Test15 {
    public static void main(String[] args) {
        int[] arr = {44,78,34,56,12};
        int len = arr.length;
        for(int i=0;i<len;i++){//控制轮数
            for(int j=0;j<len-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    //  44 34 78 56 12
    //  44 34 56 12 78   第一轮
    //  34 44 12 56 78  第二轮
    //  34 12 44 56 78  第三轮
    //  12 34 44 56 78  第四轮


}
