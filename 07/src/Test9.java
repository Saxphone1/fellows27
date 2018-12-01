import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Test9 {
    public static void main(String[] args) {
        String i1 = "51461651645264";
        String i2 = "41154646562456";
        BigInteger i3 = new BigInteger(i1);
        BigInteger i4 = new BigInteger(i2);
        System.out.println(i3.add(i4));
        System.out.println(i3.subtract(i4));
        System.out.println(i3.multiply(i4));
        System.out.println(i3.divide(i4));
        System.out.println(i3.remainder(i4));
        System.out.println(Arrays.toString(i3.divideAndRemainder(i4)));

        String i5 = "123.5145413451345";
        String i6 = "23.51514545134";
        BigDecimal b1 = new BigDecimal(i5);
        BigDecimal b2 = new BigDecimal(i6);
        System.out.println(b1.add(b2));
        System.out.println(b1.subtract(b2));
        System.out.println(b1.multiply(b2));
//        System.out.println(b1.divide(b2));
        System.out.println(b1.divide(b2,2,BigDecimal.ROUND_HALF_UP));
        System.out.println("------------------");
        double pi=3.1415927;//圆周率
//取一位整数，结果：3
        System.out.println(new DecimalFormat("0").format(pi));
//取一位整数和两位小数，结果3.14
        System.out.println(new DecimalFormat("0.00").format(pi));
//取两位整数和三位小数，整数不足部分以0填补，结果：03.142
        System.out.println(new DecimalFormat("00.000").format(pi));
//取所有整数部分，结果：3
        System.out.println(new DecimalFormat("#").format(pi));
//以百分比方式计数，并取两位小数，结果：314.16%
        System.out.println(new DecimalFormat("#.##%").format(pi));



    }
}
