package xyz.mdou.quickstart.util.concurrent.locks;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ReentrantLockTest {

    private ReentrantLock lock = new ReentrantLock();
    private int state = 0;

    @Test
    public void test() throws InterruptedException {
        Runnable lockTask = () -> {
            lock.lock();
            try {
                state += 1;
                System.out.println(String.format("locked by %s, state %d",
                        Thread.currentThread().getName(), state));
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        };
        Runnable checkTask = () -> {
            IntStream.range(1, 10).forEach(i -> {
                System.out.println(String.format("%s check lock is %s, state %d",
                        Thread.currentThread().getName(),
                        lock.isLocked() ? "locked" : "unlocked", state));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        };
        ExecutorService lockExecutor = Executors.newFixedThreadPool(5);
        IntStream.range(0, 5).forEach(i -> lockExecutor.submit(lockTask));
        ExecutorService checkExecutor = Executors.newFixedThreadPool(3);
        IntStream.range(0, 3).forEach(i -> checkExecutor.submit(checkTask));
        TimeUnit.SECONDS.sleep(10);
    }
}
