package xyz.mdou.quickstart.concurrent;

import xyz.mdou.quickstart.collections.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionIntoStream {

    public static void main(String[] args) {
        List<String> strings = Stream.generate(() -> Randoms.string(5)).limit(10).collect(Collectors.toList());
        System.out.println(strings);
        String result = strings.stream().map(String::toUpperCase).reduce(":", (a, b) -> a + b);
        System.out.println(result);
    }
}
