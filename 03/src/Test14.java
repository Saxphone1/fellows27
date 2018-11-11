public class Test14 {
    public static void main(String[] args) {
        int[] arr = {3,7,12,43,56,89};
        // arr  7
        int index = selection(arr,3);
        System.out.println(index);
    }
    public static int selection(int[] arr,int val){
        int start = 0;
        int end = arr.length-1;
        do{
            int i = (start + end)/2;
            if(val > arr[i]){
                start = i + 1;
            }else if(val < arr[i]){
                end = i-1;
            }else{
                return i;
            }
            System.out.println(i);
        }while (start <= end);
        return -1;
    }
}
