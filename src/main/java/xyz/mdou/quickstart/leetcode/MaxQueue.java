package xyz.mdou.quickstart.leetcode;

import java.util.*;

class MaxQueue {

    private Deque<Integer> data;
    private Deque<Integer> maxValue;

    public MaxQueue() {
        data = new ArrayDeque<>();
        maxValue = new ArrayDeque<>();
    }
    
    public int max_value() {
        if (data.isEmpty()) {
            return -1;
        }
        return maxValue.peekFirst();
    }
    
    public void push_back(int value) {
        data.offer(value);
        while (!maxValue.isEmpty() && value > maxValue.peekLast()) {
            maxValue.pollLast();
        }
        maxValue.offer(value);
    }
    
    public int pop_front() {
        if (data.isEmpty()) {
            return -1;
        }
        int value = data.pop();
        if (value == maxValue.peekFirst()) {
            maxValue.pop();
        }
        return value;
    }
}