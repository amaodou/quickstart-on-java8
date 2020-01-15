package xyz.mdou.quickstart;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Suppliers {

    public static <T, R extends Collection<T>> R create(Supplier<R> factory, Supplier<T> gen, int n) {
        return Stream.generate(gen).limit(n).collect(factory, R::add, R::addAll);
    }

    public static <T, R extends Collection<T>> R fill(R r, Supplier<T> gen, int n) {
        Stream.generate(gen).limit(n).forEach(r::add);
        return r;
    }

    public static <T, R> R fill(R r, BiConsumer<T, R> bic, Supplier<T> gen, int n) {
        Stream.generate(gen).limit(n).forEach(t -> bic.accept(t, r));
        return r;
    }
}