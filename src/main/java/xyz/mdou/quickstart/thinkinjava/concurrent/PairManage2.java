package xyz.mdou.quickstart.thinkinjava.concurrent;

public class PairManage2 extends PairManage {

    @Override
    public void increment() {
        Pair tmp = null;
        synchronized (this) {
            p.incrementY();
            p.incrementX();
            tmp = getPair();
        }
        store(tmp);
    }
}