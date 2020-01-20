package xyz.mdou.quickstart.concurrent;

import java.util.Arrays;

public class Summing3 {

    private static final int SZ = 10000000;
    private static final Long CHECK = (long) SZ * ((long) SZ + 1) / 2;

    static long basicSum(Long[] la) {
        long sum = 0L;
        for (long i : la) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Long[] la = new Long[SZ + 1];
        Arrays.setAll(la, Long::valueOf);
        Summing.testTime("array stream", CHECK, () -> Arrays.stream(la).reduce(0L, Long::sum));
        Summing.testTime("array stream parallel", CHECK, () -> Arrays.stream(la).parallel().reduce(0L, Long::sum));
        Summing.testTime("array stream basic", CHECK, () -> basicSum(la));
        Summing.testTime("parallelPrefix", CHECK, () -> {
            Arrays.parallelPrefix(la, Long::sum);
            return la[la.length - 1];
        });
    }
}
