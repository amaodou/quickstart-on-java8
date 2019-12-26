package xyz.mdou.quickstart.functional;

import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionComposition {
    static Function<String, String> f1 = s -> s.replace(" ", "");
    static Function<String, String> f2 = s -> s.substring(3);
    static Function<String, String> f3 = String::toUpperCase;
    static Function<String, String> f4 = f1.compose(f2).compose(f3);
    static Function<String, Integer> f5 = f1.andThen(Integer::valueOf);

    public static void main(String[] args) {
        System.out.println(f4.apply("tomorrow is friday"));

        System.out.println(f5.apply("123"));

        System.out.println(Stream.generate(() -> "tomorrow is friday")
                .map(s -> s.replace(" ", ""))
                .map(s -> s.substring(3))
                .map(String::toUpperCase)
                .peek(System.out::println)
                .findFirst().orElse(""));
    }

}
