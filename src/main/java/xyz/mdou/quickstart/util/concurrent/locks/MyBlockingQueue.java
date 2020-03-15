package xyz.mdou.quickstart.util.concurrent.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class MyBlockingQueue<E> {

    private ReentrantLock lock;
    private Condition notFull;
    private Condition notEmpty;

    private Object[] items;
    private int count;
    private int putIndex;
    private int takeIndex;
    private int capacity;

    public MyBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.items = new Object[capacity];
        this.lock = new ReentrantLock(false);
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count >= capacity;
    }

    public void put(E e) throws InterruptedException {
        lock.lock();
        try {
            while (isFull()) {
                notFull.await();
            }
            enqueue(e);
        } finally {
            lock.unlock();
        }
    }

    private void enqueue(E e) {
        items[putIndex] = e;
        putIndex += 1;
        if (putIndex >= items.length) {
            putIndex = 0;
        }
        count += 1;
        System.out.printf("%s put %s at %s, %d\r\n", Thread.currentThread().getName(),
                e, putIndex, count);
        notEmpty.signal();
    }

    public E dequeue() {
        Object o = items[takeIndex];
        takeIndex += 1;
        if (takeIndex >= items.length) {
            takeIndex = 0;
        }
        count -= 1;
        System.out.printf("%s take %s at %s, %d\r\n", Thread.currentThread().getName(),
                o, takeIndex, count);
        notFull.signal();
        return (E) o;
    }

    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            long nano = unit.toNanos(timeout);
            while (isFull()) {
                if (nano < 0) {
                    return false;
                }
                notFull.awaitNanos(nano);
            }
            enqueue(e);
            return true;
        } finally {
            lock.unlock();
        }
    }

    public E take() throws InterruptedException {
        lock.lock();
        try {
            while (isEmpty()) {
                notEmpty.await();
            }
            return dequeue();
        } finally {
            lock.unlock();
        }
    }

    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            long nano = unit.toNanos(timeout);
            while (isEmpty()) {
                if (nano < 0) {
                    return null;
                }
                notFull.awaitNanos(nano);
            }
            return dequeue();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(10);
        ExecutorService pollExecutor = Executors.newFixedThreadPool(100);
        IntStream.range(0, 1000).forEach(i -> {
            pollExecutor.submit(() -> {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        ExecutorService offerExecutor = Executors.newFixedThreadPool(100);
        IntStream.range(0, 1000).forEach(i -> {
            offerExecutor.submit(() -> {
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(60000);
    }
}


