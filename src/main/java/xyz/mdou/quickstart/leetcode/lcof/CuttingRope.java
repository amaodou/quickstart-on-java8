package xyz.mdou.quickstart.leetcode.lcof;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题14- I. 剪绳子
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
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
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 */
public class CuttingRope {

    public int cuttingRope(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int threeCount = n / 3;
        int leftLength = n % 3;
        if (leftLength == 1) {
            return (int) (Math.pow(3, threeCount - 1) * 4);
        } else if (leftLength == 0) {
            return (int) (Math.pow(3, threeCount));
        } else {
            return (int) (Math.pow(3, threeCount) * (leftLength));
        }
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
        Assert.assertEquals(36, cuttingRope(10));
    }
}
