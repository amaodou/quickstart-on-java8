package xyz.mdou.quickstart.thinkinjava.concurrent;

public class PairChecker implements Runnable {

    private PairManage pairManage;

    public PairChecker(PairManage pairManage) {
        this.pairManage = pairManage;
    }

    @Override
    public void run() {
        while (true) {
            pairManage.count.incrementAndGet();
            pairManage.getPair().checkState();
        }
    }
}
