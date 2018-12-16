public class Test2 {
    public static void main(String[] args) {
//        1、验证电话号码（如：010-38389438 ）
            String s =  "010-38389438";
            s.matches("\\d{3,4}-\\d{7,8}");


//        2、验证手机号码
            String s1 = "13456788923";
            s1.matches("1[3-9]\\d{9}");

//        3、验证用户名，只能是字母开头的 数字、字母或下划线的组合
            String s2 = "";
            s2.matches("[a-zA-Z]\\w*");

//        4、验证IP地址（如：192.168.1.1）
            String s3 = "";
            s3.matches("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}");
//        5、验证网址（如：http://www.baidu.com）

//        6、验证年龄（100以内）
//        7、验证金额（可以有小数位）

    }
}
