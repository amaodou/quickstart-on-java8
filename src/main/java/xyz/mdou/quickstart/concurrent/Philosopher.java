package xyz.mdou.quickstart.concurrent;

public class Philosopher implements Runnable {
    private int seat;
    private StickHolder left;
    private StickHolder right;

    Philosopher(int seat, StickHolder left, StickHolder right) {
        this.seat = seat;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true) {
            right.pickUp();
            System.out.println(seat + " " + Thread.currentThread().getName() + " right pickUp");
            left.pickUp();
            System.out.println(seat + " " + Thread.currentThread().getName() + " left pickUp");
            System.out.printf("***************philosopher %d eating***************\r\n", seat);
            right.putDown();
            System.out.println(seat + " " + Thread.currentThread().getName() + " right putDown");
            left.putDown();
            System.out.println(seat + " " + Thread.currentThread().getName() + " left putDown");
        }
    }
}
