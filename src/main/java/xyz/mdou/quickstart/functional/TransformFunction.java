package xyz.mdou.quickstart.functional;

import java.util.function.Function;

class I {}
class O {}
class C {}

public class TransformFunction {

    static Function<I, C> transform(Function<I, O> in) {
        return in.andThen(o -> {
            System.out.println(o);
            return new C();
        });
    }

    public static void main(String[] args) {
        Function<I, C> f = transform(i -> new O());
        f.apply(new I());
    }
}
