package xyz.mdou.quickstart.leetcode;

import java.util.*;

/**
 * 面试题59 - II. 队列的最大值
 *
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *  
 *
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 */
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