public class Test2 {
    public static void main(String[] args) {

        MyRunnable2 mr = new MyRunnable2();
        Thread t = new Thread(mr);
        t.start();

        for(int i = 0; i < 50; i++){
            if(i == 20){
//                try {
//                    t.join();//等待t线程执行完毕
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                t.interrupt();//中断t线程，打了一中断标记
                mr.setFlag(false);
            }
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }
}

class MyRunnable2 implements Runnable {
    private boolean flag = true;//true代表线程没有中断

    public MyRunnable2() {
        flag = true;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
       int i = 0;
       while (flag){
           System.out.println(Thread.currentThread().getName()+"--"+i++);
       }
    }
}

class MyRunnable1 implements Runnable{
    private boolean flag = true;//true代表线程没有中断
    public MyRunnable1(){
        flag = true;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if(Thread.interrupted()){//测试中断状态
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
//                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }
}
