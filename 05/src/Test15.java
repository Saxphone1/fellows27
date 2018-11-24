import com.weichuang.product.Test1;
public class Test15 {
    public static void main(String[] args) {

//        Integer i1 = new Integer(10);//装箱
//        int i2 = i1.intValue();//拆箱
//
//        int i3 = Integer.parseInt("123");
//        System.out.println(i3);

        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        System.out.println(i1 == i2);

        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.println(i3 == i4);

        Integer i5 = 10;
        Integer i6 = 10;
        System.out.println(i5 == i6);

        Integer i7 = 127;
        Integer i8 = 127;
        System.out.println(i7 == i8);




    }
}


