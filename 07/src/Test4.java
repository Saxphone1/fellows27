import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

//-Dfile.encoding=UTF-8
public class Test4 {
    public static void main(String[] args) {
        Locale l1 = new Locale("zh","CN");
        Locale l2 = new Locale("en","US");
        Locale defaultL = Locale.getDefault();//选择系统默认语言
        ResourceBundle r = ResourceBundle.getBundle("com.weichuang.info");
        System.out.println(r.getString("system.name"));
        System.out.println(r.getString("input.username"));
        Scanner input = new Scanner(System.in);
        String username = input.next();
        System.out.println(r.getString("input.password"));
        String pwd = input.next();

        if("admin".equals(username) && "1234".equals(pwd)){
            System.out.println(r.getString("login.success"));
            String str = r.getString("welcome");
            str = MessageFormat.format(str,username);
            System.out.println(str);
        }else{
            System.out.println(r.getString("login.error"));

        }

    }
}
