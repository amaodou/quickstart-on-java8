package xyz.mdou.quickstart.functional;

import java.util.function.Function;

interface FunctionString extends Function<String, String> {}

public class ProduceFunction {
    static FunctionString f() {
        return String::toLowerCase;
    }

    public static void main(String[] args) {
        FunctionString fs = f();
        System.out.println(fs.apply("HELLO, WORLD"));
    }
}
