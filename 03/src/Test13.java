import java.util.Arrays;

public class Test13 {
    public static void main(String[] args) {
        int[] arr = {44,78,34,56,12};
        int len = arr.length;
        for(int i=1;i<len;i++){
            int temp = arr[i];
            int j;
            for(j=i-1;j>=0;j--){
                if(arr[j] > temp){
                    arr[j+1] = arr[j];
                }else{
                    arr[j+1] = temp;
                    break;
                }
                if(j == 0){
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //  34 44 78 56 12
    //  34 44 78 56 12     第二轮   temp = 34
    //  34 44 56 78 12     第三轮   temp = 56
    //  12 34 44 56 78     第三轮   temp = 12


}
