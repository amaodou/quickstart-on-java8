package xyz.mdou.quickstart.jvm;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * java -Xms200M -Xmx200M -XX:+PrintGC xyz.mdou.quickstart.jvm.OutOfMemory
 */
public class OutOfMemory {
    private static ScheduledThreadPoolExecutor executor =
            new ScheduledThreadPoolExecutor(50, new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void main(String[] args) throws InterruptedException {
        executor.setMaximumPoolSize(50);

        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        System.out.println(map.size());

        while (true) {
            checkCardInfo();
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }

    private static void checkCardInfo() {
        List<CardInfo> cardInfos = getAllCardInfo();
        cardInfos.forEach(
                c -> executor.scheduleAtFixedRate(c::empty, 2, 3, TimeUnit.SECONDS)
        );
    }

    public static List<CardInfo> getAllCardInfo() {
        List<CardInfo> cardInfos = new ArrayList<>();
        IntStream.range(0, 100).forEach(
                i -> cardInfos.add(new CardInfo())
        );
        return cardInfos;
    }

    static class CardInfo {
        private BigDecimal price = new BigDecimal("0.0");
        private String name = "lizhiyong";
        private int age = 5;
        private Date birthday = new Date();

        public void empty() {

        }
    }
}
