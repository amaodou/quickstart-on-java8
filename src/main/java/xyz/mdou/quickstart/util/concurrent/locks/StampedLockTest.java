package xyz.mdou.quickstart.util.concurrent.locks;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

public class StampedLockTest {

    private StampedLock stampedLock = new StampedLock();
    private int state = 0;

    public void writeLock() throws InterruptedException {
        long stamp = stampedLock.writeLock();
        try {
            state += 1;
            System.out.printf("%s get writeLock, state %d\r\n",
                    Thread.currentThread().getName(), state);
            TimeUnit.SECONDS.sleep(3);
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public void readLock() throws InterruptedException {
        long stamp = stampedLock.readLock();
        try {
            int readState = state;
            System.out.printf("%s get readLock, state %d\r\n",
                    Thread.currentThread().getName(), readState);
            TimeUnit.SECONDS.sleep(1);
        } finally {
            stampedLock.unlockRead(stamp);
        }
    }

    public void optimisticReadLock() throws InterruptedException {
        long stamp = stampedLock.tryOptimisticRead();
        int readState = state;
        TimeUnit.SECONDS.sleep(1);
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();
            try {
                readState = state;
                System.out.printf("%s optimisticRead is not validate, retry get state %d\r\n",
                        Thread.currentThread().getName(), readState);
                TimeUnit.SECONDS.sleep(1);
            } finally {
                stampedLock.unlock(stamp);
            }
        }
        System.out.printf("%s optimisticRead is validate, state %d\r\n",
                Thread.currentThread().getName(), readState);
    }

    @Test
    public void testLock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        IntStream.range(0, 1).forEach(i -> {
            executorService.submit(() -> {
                try {
                    optimisticReadLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
        IntStream.range(0, 1).forEach(i -> {
            executorService.submit(() -> {
                try {
                    writeLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
        IntStream.range(0, 10).forEach(i -> {
            executorService.submit(() -> {
                try {
                    readLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
        TimeUnit.SECONDS.sleep(60);
    }
}
