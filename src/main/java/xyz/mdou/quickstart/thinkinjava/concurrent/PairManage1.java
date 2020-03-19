package xyz.mdou.quickstart.thinkinjava.concurrent;

public class PairManage1 extends PairManage {

    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}
