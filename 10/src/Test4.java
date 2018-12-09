import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test4 {
    public static void main(String[] args) {
        MyRunnable4 mr4 = new MyRunnable4();
        Thread t1 = new Thread(mr4);
        Thread t2 = new Thread(mr4);
        t1.start();
        t2.start();
    }
}

class MyRunnable4 implements Runnable{
    private int ticket = 300;
//    private Object o = new Object();
    private Lock lock =  new ReentrantLock();
    @Override
    public void run() {
        for (int i = 0; i <300 ; i++) {
//            synchronized (this){
//                ticket--;
//                if(ticket >= 0 && ticket <10){
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName()+"剩余"+ticket+"张");
//                }
//            }
            method1();
        }
    }

    public synchronized void method(){
        ticket--;
        if(ticket >= 0 && ticket <10){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"剩余"+ticket+"张");
        }
    }

    public void method1(){
        lock.lock();
        try{
            ticket--;
            if(ticket >= 0 && ticket <10){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"剩余"+ticket+"张");
            }
        }finally {
            lock.unlock();
        }

    }
}
