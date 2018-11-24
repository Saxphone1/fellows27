public class Test11 {
    public static void main(String[] args) {
        UserImpl user = new UserImpl();
        ProxyUserImpl pui = new ProxyUserImpl(user);
        pui.Buy();
    }
}

class ProxyUserImpl implements IShopping{
    public IShopping is;//被代理对象
    public ProxyUserImpl(IShopping is){
        this.is = is;
    }
    public void Buy(){
        long startTime = System.currentTimeMillis();
        is.Buy();
        long endTime = System.currentTimeMillis();
        System.out.println("一共花费时间为："+(endTime - startTime));

    }
}

interface IShopping{
    public void Buy();
}
class UserImpl implements IShopping{
    public void Buy(){
        for(int i=0;i<10;i++){
            System.out.println("我在shopping....");
        }
    }
}