import java.util.Arrays;

public class Test16 {
    public static void main(String[] args) {
//        int[] arr = {2,5,22,34,67,89,96};
//        int index = Arrays.binarySearch(arr,2,5,34);
        int[] arr1 = {2,32,12,54,67,43,56};
//        Arrays.sort(arr1);
//        int[] arr2 = Arrays.copyOf(arr1,10);
//        int[] arr2 = Arrays.copyOf(arr1,7);

//        Arrays.fill(arr1,10);
        Arrays.fill(arr1,2,6,10);
//        System.out.println(Arrays.equals(arr1,arr2));
        System.out.println(Arrays.toString(arr1));

    }
}
