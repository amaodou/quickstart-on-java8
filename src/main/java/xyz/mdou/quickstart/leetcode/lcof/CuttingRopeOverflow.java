package xyz.mdou.quickstart.leetcode.lcof;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题14- II. 剪绳子 II
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * 提示：
 * 2 <= n <= 1000
 *
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
 */
public class CuttingRopeOverflow {

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long max = 1;
        int count3 = n / 3;
        for (int i = 0; i < count3 - 1; i++) {
            max = (max * 3) % 1000000007;
        }
        int restN = n % 3;
        if (restN == 0) return (int) ((max * 3) % 1000000007);
        if (restN == 1) return (int) ((max * 4) % 1000000007);
        return (int) ((max * 3 * restN) % 1000000007);
    }

    @Test
    public void testLetter() {
        Assert.assertEquals(0, cuttingRope(1));
        Assert.assertEquals(1, cuttingRope(2));
        Assert.assertEquals(2, cuttingRope(3));
    }

    @Test
    public void testNormal() {
        Assert.assertEquals(18, cuttingRope(8));
        Assert.assertEquals(324522920, cuttingRope(59));
    }
}
