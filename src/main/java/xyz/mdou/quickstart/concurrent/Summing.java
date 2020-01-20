package xyz.mdou.quickstart.concurrent;

import xyz.mdou.quickstart.Timer;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

public class Summing {

    private static final Long SZ = 100000000L;
//    private static final Long SZ = 1000000000L;
    private static final Long CHECK = SZ * (SZ + 1) / 2;

    public static void testTime(String id, long checkValue, LongSupplier supplier) {
        System.out.print(id + ": ");
        Timer timer = new Timer();
        long result = supplier.getAsLong();
        if (result == checkValue) {
            System.out.println(timer.duration() + " ms");
        } else {
            System.out.format("result: %d%ncheckValue: %d%n", result, checkValue);
        }
    }

    public static void main(String[] args) {
        testTime("sum stream", CHECK, () -> LongStream.rangeClosed(0, SZ).sum());
        testTime("sum stream parallel", CHECK, () -> LongStream.rangeClosed(0, SZ).parallel().sum());
        testTime("sum iterate", CHECK, () -> LongStream.iterate(0, i -> i + 1).limit(SZ + 1).sum());
        testTime("sum iterate parallel", CHECK, () -> LongStream.iterate(0, i -> i + 1).limit(SZ + 1).parallel().sum());
    }
}
