import java.util.Arrays;

public class Test12 {
    public static void main(String[] args) {
        int[] arr = {44,78,34,56,12};
        int len = arr.length;
        for(int i=0;i<len;i++){//控制当前轮数
            int minIndex = i;  //当前最小值得对应下标
            for(int j=i+1;j<len;j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //  44 78 34 56 12
    //  12 78 34 56 44                   //第0 轮  minIndex = 4
    //  12 34 78 56 44                   //第1轮  minIndex=2

}
