public class Test5 {
    //NullPointerException
    public static void main(String[] args) {
        print(null);//null代表空对象，相当于传一个空值
    }
    public static void print(int[] a){
        System.out.println(a.length);//调用了一个空对象的属性或方法
    }
}
