package xyz.mdou.quickstart;

import java.util.AbstractList;

public class CountingIntegerList extends AbstractList<Integer> {

    private int size;

    public CountingIntegerList() {
        this.size = 0;
    }

    public CountingIntegerList(int size) {
        this.size = size > 0 ? size : 0;
    }

    @Override
    public Integer get(int index) {
        return index;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CountingIntegerList clist = new CountingIntegerList(30);
        System.out.println(clist);
        System.out.println(clist.get(100));
    }
}
