package xyz.mdou.quickstart.thinkinjava.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class PairManage {

    AtomicInteger count = new AtomicInteger(0);

    private List<Pair> pairs = Collections.synchronizedList(new ArrayList<>());

    protected Pair p = new Pair();

    public synchronized Pair getPair() {
        return new Pair(p.getX(), p.getY());
    }

    protected void store(Pair p) {
        pairs.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void increment();
}



