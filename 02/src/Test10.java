public class Test10 {
    public static void main(String[] args) {
        int year = 30;

        if((year % 4 == 0 && year % 100 !=0) || year % 400 == 0){
            System.out.println("闰年");
        }else{
            System.out.println("平年");
        }
    }
}
