package xyz.mdou.quickstart.functional;

import java.util.function.Function;

/**
 * 柯里化意为：将一个多参数的函数，转换为一系列单参数函数。
 */
public class CurryingAndPartials {

    // 未柯里化的函数
    private static String uncurried(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(uncurried("Hi ", "mdou"));

        Function<String, Function<String, String>> curried = a -> b -> a + b;  // 柯里化的函数
        System.out.println(curried.apply("Hi ").apply("mdou"));
    }
}
