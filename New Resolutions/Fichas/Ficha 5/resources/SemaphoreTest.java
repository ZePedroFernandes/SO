
import java.util.concurrent.*;

public class SemaphoreTest {

    static Semaphore s = new Semaphore(0);

    public void fun(final char c, final int r) throws Exception {
        new Thread(() -> {
            try {
                System.out.println("acquire " + r);
                s.acquire(r);
                System.out.println(c + "_" + r);
            } catch (InterruptedException e) {
            }
        }).start();
        Thread.sleep(500);
    }

    public static void main(String[] args) throws Exception {
        SemaphoreTest f = new SemaphoreTest();

        f.fun('C', 7);
        f.fun('B', 2);
        f.fun('A', 5);

        while (s.hasQueuedThreads()) {
            Thread.sleep(1000);
            System.out.println("release " + 1 + ", available " + (s.availablePermits() + 1));
            s.release(1);
        }
    }
}
