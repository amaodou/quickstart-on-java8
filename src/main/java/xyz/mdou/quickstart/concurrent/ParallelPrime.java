package xyz.mdou.quickstart.concurrent;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ParallelPrime {
    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();
        List<String> primes = LongStream.iterate(2, i -> i + 1)
                .parallel()
                .filter(ParallelPrime::isPrime)
                .limit(100000)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
        System.out.printf("cost %d ms", (System.nanoTime() - start) / 1000);

        Files.write(Paths.get("parallel.txt"), primes, Charset.forName("utf-8"), StandardOpenOption.CREATE);
    }

    public static boolean isPrime(long n) {
        return LongStream.rangeClosed(2, (long)Math.sqrt(n)).noneMatch(i -> n % i == 0);
    }
}
