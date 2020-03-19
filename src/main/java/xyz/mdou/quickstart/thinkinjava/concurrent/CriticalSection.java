package xyz.mdou.quickstart.thinkinjava.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CriticalSection {

    public static void test(PairManage pairManage1, PairManage pairManage2) throws InterruptedException {
        PairManipulator pm1 = new PairManipulator(pairManage1);
        PairManipulator pm2 = new PairManipulator(pairManage2);

        PairChecker checker1 = new PairChecker(pairManage1);
        PairChecker checker2 = new PairChecker(pairManage2);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(pm1);
        executorService.execute(pm2);
        executorService.execute(checker1);
        executorService.execute(checker2);

        TimeUnit.SECONDS.sleep(5);
        System.out.println("pm1 " + pm2 + "\r\npm2 " + pm2);
        System.exit(0);
    }

    public static void main(String[] args) throws InterruptedException {
        PairManage pairManage1 = new PairManage1();
        PairManage pairManage2 = new PairManage2();
        test(pairManage1, pairManage2);
    }
}
