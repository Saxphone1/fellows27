public class Test10 {
    public static void main(String[] args){
        int[] arr = {12,32,21,43,2,46,97};
        int len = arr.length;
        int min = arr[0];
        for(int i=1;i<len;i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        System.out.println(min);
    }
}
