package xyz.mdou.quickstart.functional;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateComposition {
    static Predicate<String> p1 = s -> s.length() < 10;
    static Predicate<String> p2 = s -> s.contains("hello");
    static Predicate<String> p3 = s -> s.contains("bar");
    static Predicate<String> p4 = p1.negate().and(p2).or(p3);

    public static void main(String[] args) {
        Stream.of("bar", "hello", "abcd").filter(p4).forEach(System.out::println);
    }
}
