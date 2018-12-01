import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import static java.lang.Math.sqrt;
public class Test5 {
    public static void main(String[] args) {
        System.out.println(Math.abs(-10));
        System.out.println(Math.random());
        System.out.println(sqrt(2));
        Random r = new Random();
        System.out.println(r.nextInt(50));

        Date date = new Date();
        System.out.println(date);

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = new GregorianCalendar();

        System.out.println(c1.get(Calendar.YEAR));
        System.out.println(c1.get(Calendar.MONTH));
        System.out.println(c1.get(Calendar.DAY_OF_MONTH));
        System.out.println(c1.get(Calendar.HOUR_OF_DAY));
        System.out.println(c1.get(Calendar.MINUTE));
        System.out.println(c1.get(Calendar.SECOND));
        System.out.println(c1.get(Calendar.MILLISECOND));

        StringBuffer sb = new StringBuffer(50);
        sb.append(c1.get(Calendar.YEAR)).append("年");
        System.out.println(sb.toString());

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
        System.out.println(df.format(date));




    }
}
