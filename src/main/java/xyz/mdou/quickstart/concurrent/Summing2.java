package xyz.mdou.quickstart.concurrent;

import java.util.Arrays;

public class Summing2 {

    private static final int SZ = 100000000;
    private static final Long CHECK = (long) SZ * ((long) SZ + 1) / 2;

    static long basicSum(long[] la) {
        long sum = 0L;
        for (long i : la) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        long[] la = new long[SZ + 1];
        Arrays.setAll(la, i -> i);
        Summing.testTime("array stream", CHECK, () -> Arrays.stream(la).sum());
        Summing.testTime("array stream parallel", CHECK, () -> Arrays.stream(la).parallel().sum());
        Summing.testTime("array stream basic", CHECK, () -> basicSum(la));
        Summing.testTime("parallelPrefix", CHECK, () -> {
            Arrays.parallelPrefix(la, Long::sum);
            return la[la.length - 1];
        });
    }
}
