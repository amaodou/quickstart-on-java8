package xyz.mdou.quickstart.leetcode.lcof;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题10- I. 斐波那契数列
 *
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 *  
 *
 * 提示：
 *
 * 0 <= n <= 100
 *
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 */
public class Fibonacci {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int f1 = 0;
        int f2 = 1;
        for (int i = 2; i < n; i++) {
            int tmp = (f1 + f2) % 1000000007;
            f1 = f2;
            f2 = tmp;
        }
        System.out.println(f1);
        System.out.println(f2);
        return (f1 + f2) % 1000000007;
    }

    @Test
    public void testZero() {
        Assert.assertEquals(0, 0);
    }

    @Test
    public void testOne() {
        Assert.assertEquals(1, fib(1));
    }

    @Test
    public void testNormal() {
        Assert.assertEquals(5, fib(5));
        fib(95);
    }
}
