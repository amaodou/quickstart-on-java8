package xyz.mdou.quickstart;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountMap extends AbstractMap<Integer, String> {

    private static final char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private int size;

    public CountMap(int size) {
        this.size = size;
    }

    public static String value(Integer key) {
        return String.format("%s%d", chars[key % chars.length], key / chars.length);
    }

    public static void main(String[] args) {
        CountMap countMap = new CountMap(50);
        System.out.println(countMap);
        System.out.println(countMap.get(100));
        countMap.values().stream().limit(6).forEach(System.out::println);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String get(Object key) {
        return value((Integer) key);
    }

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        return IntStream.range(0, size).boxed().map(Entry::new)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static class Entry implements Map.Entry<Integer, String> {

        private int index;

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return value(index);
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException("readonly entry");
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(index);
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Entry && Objects.equals(index, ((Entry) obj).index);
        }
    }
}
