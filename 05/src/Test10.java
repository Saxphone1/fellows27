public class Test10 {
    public static void main(String[] args) {
        Product p = ProductFactory.getProduct("aa");
        if(null != p){
            p.work();
        }
    }
}
class ProductFactory{
    public static Product getProduct(String data){
        if(data.equals("phone")){
            return new Phone();
        }else if("computer".equals(data)){
            return new Computer();
        }
        return null;
    }
}
abstract class Product{
    public abstract void work();
}

class Phone extends Product{
    public void work(){
        System.out.println("手机正在工作。。。");
    }
}
class Computer extends Product{
    public void work(){
        System.out.println("电脑正在工作。。。。");
    }
}

