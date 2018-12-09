public class Test6 {
    public static void main(String[] args) {
        Food f = new Food();
        Producter p = new Producter(f);
        Customers c = new Customers(f);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}

class Customers implements Runnable{
    private Food food;
    public Customers(Food food){
        this.food = food;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            food.get();
        }
    }
}

class Producter implements Runnable{
    private Food food;
    public Producter(Food food){
        this.food = food;
    }
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            if(i%2 == 0){
                food.set("麻辣烫","麻辣");
            }else{
                food.set("米线","酸甜");
            }
        }
    }
}

class Food{
    private String name;
    private String desc;
    private boolean flag = true;//true代表可以生产,false可以消费
    public Food() {

    }
    public Food(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    //生产产品
    public synchronized void set(String name,String desc){
        //可以消费,
        if(!flag){
            //不能生产
            try {
                this.wait();//等待调用 notify()或者notifyAll()唤醒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setName(name);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setDesc(desc);
        flag = false;//变成可以消费
        this.notify();
    }
    //消费产品
    public synchronized void get(){
        //可以生产，不能消费
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name+"->"+this.getDesc());
        this.flag = true;//变成可以生产
        this.notify();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
