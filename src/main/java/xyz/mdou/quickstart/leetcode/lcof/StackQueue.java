package xyz.mdou.quickstart.leetcode.lcof;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 面试题09. 用两个栈实现队列
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 */
public class StackQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public StackQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void appendTail(int value) {
        pushStack.push(value);
    }

    public int deleteHead() {
        if (!popStack.isEmpty()) {
            return popStack.pop();
        }
        if (pushStack.isEmpty()) {
            return -1;
        }
        while (pushStack.size() > 1) {
            popStack.push(pushStack.pop());
        }
        return pushStack.pop();
    }

    @Test
    public void testEmptyDeleteHead() {
        Assert.assertEquals(-1, new StackQueue().deleteHead());
    }

    @Test
    public void testNormal() {
        StackQueue queue = new StackQueue();
        queue.appendTail(5);
        queue.appendTail(2);
        Assert.assertEquals(queue.deleteHead(), 5);
        Assert.assertEquals(queue.deleteHead(), 2);
    }

}
