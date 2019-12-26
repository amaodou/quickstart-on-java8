package xyz.mdou.quickstart.functional;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

/**
 * 柯里化意为：将一个多参数的函数，转换为一系列单参数函数。
 * 柯里化基本类型和装箱
 */
public class CurriedIntAdd {

    public static void main(String[] args) {
        IntFunction<IntUnaryOperator> ci = a -> b -> a + b;
        System.out.println(ci.apply(1).applyAsInt(3));

        IntFunction<IntUnaryOperator> bi = a -> {
            return new IntUnaryOperator() {
                @Override
                public int applyAsInt(int b) {
                    return a + b;
                }
            };
        };
    }
}
