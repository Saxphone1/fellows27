public class Test5 {
    public static void main(String[] args) {
       new MyRunnable5();
    }
}

class MyRunnable5 implements Runnable{
    Cusomer c = new Cusomer();
    Waiter w = new Waiter();
    public MyRunnable5(){
        new Thread(this).start();
        w.say(c);
    }
    @Override
    public void run() {
        c.say(w);
    }
}

class Cusomer{
    public synchronized void say(Waiter w){
        System.out.println("顾客说：先吃饭在买单");
        w.doService();
    }
    public synchronized void doService(){
        System.out.println("同意了,买完单再吃饭");
    }
}
class Waiter{
    public synchronized void say(Cusomer c){
        System.out.println("服务员说：先买单再吃饭");
        c.doService();
    }
    public synchronized void doService(){
        System.out.println("同意了,吃完饭再买单");
    }
}
