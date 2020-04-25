package xyz.mdou.quickstart.leetcode.lcof;

public class CustomStack {

    private int[] data;
    private int top;

    public CustomStack() {
        data = new int[32];
        top = -1;
    }

    public int pop() {
        if (top < 0) {
            throw new RuntimeException("no data in stack");
        }
        return data[top--];
    }

    public void push(int v) {
        if (top >= data.length) {
            throw new RuntimeException("stack flow");
        }
        data[++top] = v;
    }

}
