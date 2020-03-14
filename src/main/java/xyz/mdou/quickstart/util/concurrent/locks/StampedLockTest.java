package xyz.mdou.quickstart.util.concurrent.locks;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
            Thread.sleep(1000);
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
            Thread.sleep(1000);
        } finally {
            stampedLock.unlockRead(stamp);
        }
    }

    public void optimisticReadLock() throws InterruptedException {
        long stamp = stampedLock.tryOptimisticRead();
        int readState = state;
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();
            try {
                readState = state;
                System.out.printf("%s get optimisticReadLock, state %d\r\n",
                        Thread.currentThread().getName(), readState);
                Thread.sleep(1000);
            } finally {
                stampedLock.unlock(stamp);
            }
        }
    }

    @Test
    public void testLock() throws InterruptedException {
        ExecutorService writeExecutor = Executors.newFixedThreadPool(20);
        IntStream.range(0, 100).forEach(i -> {
            writeExecutor.submit(() -> {
                try {
                    writeLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
        ExecutorService readExecutor = Executors.newFixedThreadPool(20);
        IntStream.range(0, 100).forEach(i -> {
            readExecutor.submit(() -> {
                try {
                    readLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
        Thread.sleep(60000);
    }

}
