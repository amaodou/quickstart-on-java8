package xyz.mdou.quickstart.collectiontopics;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class AssociativeArray<K, V> {

    private Object[][] ts;
    private int index;

    public AssociativeArray(int length) {
        this.ts = new Object[length][2];
    }

    public void put(K k, V v) {
        if (index > ts.length) {
            throw new IndexOutOfBoundsException();
        }
        ts[index++] = new Object[]{k, v};
    }

    @SuppressWarnings(value = "unchecked")
    public V get(K k) {
        return Arrays.stream(ts)
                .filter(t -> Objects.equals(k, t[0]))
                .map(t -> (V) t[1])
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return Arrays.stream(ts)
                .filter(Objects::nonNull)
                .map(t -> t[0] + ":" + t[1])
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        AssociativeArray<String, String> map = new AssociativeArray<>(6);
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        System.out.println(map);
    }
}
