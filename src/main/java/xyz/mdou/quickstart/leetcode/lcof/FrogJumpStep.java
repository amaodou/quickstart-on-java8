package xyz.mdou.quickstart.leetcode.lcof;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题10- II. 青蛙跳台阶问题
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 提示：
 *
 * 0 <= n <= 100
 *
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 */
public class FrogJumpStep {

    public int numWays(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int f1 = 1;
        int f2 = 2;
        for (int i = 3; i < n; i++) {
            int tmp = (f2 + f1) % 1000000007;
            f1 = f2;
            f2 = tmp;
        }
        return (f2 + f1) % 1000000007;
    }

    @Test
    public void testZero() {
        Assert.assertEquals(0, numWays(0));
    }

    @Test
    public void testOne() {
        Assert.assertEquals(1, numWays(1));
    }

    @Test
    public void testNormal() {
        Assert.assertEquals(21, numWays(7));
    }
}
