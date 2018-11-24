public class Test12 {
    public static void main(String[] args) {
        PowerB powerb = new PowerBImpl();
        PowerA powera = new AdapterPowerA(powerb);
        work(powera);
    }
    public static void work(PowerA powera){
        System.out.println("正在连接。。。");
        powera.insert();
        System.out.println("工作结束。。");
    }
}

class AdapterPowerA implements PowerA{
    private PowerB powerb;
    public AdapterPowerA(PowerB powerb){
        this.powerb = powerb;
    }
    public void insert(){
        powerb.insert();
    }
}

interface PowerB{
    public void insert();
}
class PowerBImpl implements PowerB{
    public void insert(){
        System.out.println("PowerBBB工作。。。");
    }
}


interface PowerA{
    public void insert();
}

class PowerAImpl implements PowerA{
    public void insert(){
        System.out.println("PowerA工作。。。");
    }
}
