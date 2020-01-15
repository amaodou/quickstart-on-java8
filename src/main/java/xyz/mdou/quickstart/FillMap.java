package xyz.mdou.quickstart;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FillMap {

    static <K, V> Map<K, V> create(Supplier<Pair<K, V>> gen, int n) {
        return Stream.generate(gen).limit(n).collect(Collectors.toMap(Pair::getK, Pair::getV));
    }

    static <K, V> Map<K, V> fill(Map<K, V> map, Supplier<Pair<K, V>> gen, int n) {
        Stream.generate(gen).limit(n).forEach(p -> map.put(p.getK(), p.getV()));
        return map;
    }

    static <K, V> Map<K, V> create(Supplier<K> kSupplier, Supplier<V> vSupplier, int n) {
        return Stream.generate(() -> Pair.make(kSupplier.get(), vSupplier.get()))
                .limit(n)
                .collect(Collectors.toMap(Pair::getK, Pair::getV));
    }

    static <K, V, M extends Map<K,V>> M create(Supplier<K> kSupplier, Supplier<V> vSupplier, Supplier<M> mapSupplier, int n) {
        return Stream.generate(() -> Pair.make(kSupplier.get(), vSupplier.get()))
                .limit(n)
                .collect(Collectors.toMap(Pair::getK, Pair::getV, (o1, o2) -> o1, mapSupplier));
    }
}
