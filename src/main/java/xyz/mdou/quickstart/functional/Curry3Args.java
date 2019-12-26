package xyz.mdou.quickstart.functional;

import java.util.function.Function;

/**
 * 柯里化意为：将一个多参数的函数，转换为一系列单参数函数。
 * 柯里化一个三参数函数
 */
public class Curry3Args {

    public static void main(String[] args) {
        Function<String, Function<String, Function<String, String>>> f = a -> b -> c -> a + b + c;
        System.out.println(f.apply("Hello,").apply("World").apply("!"));
    }
}
