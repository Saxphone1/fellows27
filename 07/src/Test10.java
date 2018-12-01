import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

public class Test10 {
    public static void main(String[] args) {
        String password = "admin123456";
        String savePwd = "pmq7VoTEWWLYh1ZPCDRujQ==";
        try {
            Scanner input = new Scanner(System.in);
            String pwd = input.next();
            MessageDigest md5= MessageDigest.getInstance("md5");
            byte[] bs = pwd.getBytes("utf-8");
//            System.out.println(Arrays.toString(bs));
//            System.out.println(Arrays.toString(md5.digest(bs)));
            //a-z A-Z 0-9 / +
            String newStr = Base64.getEncoder().encodeToString(md5.digest(bs));
            if(savePwd.equals(newStr)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
