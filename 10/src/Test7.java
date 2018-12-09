import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test7 {
    public static void main(String[] args) {
        MyRunnable7 mr7 = new MyRunnable7();
//        ExecutorService es = Executors.newSingleThreadExecutor();
//        ExecutorService es = Executors.newFixedThreadPool(10);
        ExecutorService es = Executors.newCachedThreadPool();

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        ses.schedule(mr7,3000, TimeUnit.MILLISECONDS);
        ses.shutdown();
//        es.execute(mr7);




    }
}

class MyRunnable7 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20 ; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
