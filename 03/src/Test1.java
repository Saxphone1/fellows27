public class Test1 {


    public static void main(String[] args) {
        int len = getMenu();
        System.out.println(len);
        short s = 1;
        String str =order(s,2);//调用函数的时候 叫实参
        System.out.println(str);
    }


    public static int getMenu(){
        System.out.println("1,宫保鸡丁");
        System.out.println("2,锅包肉");
        return 2;
    }

    public static String order(int no,int xx){//定义时的参数 叫形参
        if(no == 1){
            return "宫保鸡丁";
        }else{
            return "锅包肉";
        }
    }


}
