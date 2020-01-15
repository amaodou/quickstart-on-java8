package xyz.mdou.quickstart;

public class Pair<K, V> {

    private K k;
    private V v;

    public Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }

    public static <K, V> Pair<K, V> make(K k, V v) {
        return new Pair<>(k, v);
    }
}
