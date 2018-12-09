public class Test3 {
    public static void main(String[] args) {
        MyRunnable3 mr = new MyRunnable3();
        Thread t = new Thread(mr);
        t.setDaemon(true);
        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t.isAlive());
        t.start();
        System.out.println(t.isAlive());

        for (int i = 0; i <20 ; i++) {
            System.out.println(Thread.currentThread().getName()+"=="+i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class MyRunnable3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            System.out.println(Thread.currentThread().getName()+"=="+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
