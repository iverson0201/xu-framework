package thread;

/**
 * Created by xu on 2015/6/9.
 */
public class MultiThreadTest extends Thread {

    @Override
    public void run() {
        System.out.println("sub thread test");
        try {
            Thread.sleep(99999999);
        } catch (InterruptedException e) {
            System.out.println("sub thread interrupt...");
            return;
        }
        System.out.println("sub thread end.");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread start");
        Thread t = new MultiThreadTest();
        t.start();
        t.join(2000);
        t.interrupt();
        System.out.println("main thread end");
    }
}
