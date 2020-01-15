package xyz.mdou.quickstart.collectiontopics;

import lombok.Getter;
import xyz.mdou.quickstart.Pair;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
class Letters implements Supplier<Pair<Integer, String>> {

    private int key = 1;
    private char value = 'A';

    @Override
    public Pair<Integer, String> get() {
        return Pair.make(key++, "" + value++);
    }
}

public class StreamFillMaps {
    public static void main(String[] args) {
        Map<Integer, String> map = Stream.generate(new Letters())
                .limit(10)
                .collect(Collectors.toMap(Pair::getK, Pair::getV));
        System.out.println(map);
    }
}
