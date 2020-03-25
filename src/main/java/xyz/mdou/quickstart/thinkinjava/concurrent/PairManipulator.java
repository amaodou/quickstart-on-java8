package xyz.mdou.quickstart.thinkinjava.concurrent;

import lombok.ToString;

@ToString
public class PairManipulator implements Runnable {

    private PairManage pairManage;

    public PairManipulator(PairManage pairManage) {
        this.pairManage = pairManage;
    }

    @Override
    public String toString() {
        return pairManage.getPair().toString() + ", " + pairManage.count.get();
    }

    @Override
    public void run() {
        while (true) {
            pairManage.increment();
        }
    }
}
