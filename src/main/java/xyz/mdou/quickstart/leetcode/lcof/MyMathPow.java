package xyz.mdou.quickstart.leetcode.lcof;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题16. 数值的整数次方
 *
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *  
 *
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 *
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 */
public class MyMathPow {

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long absExponent = n;
        if (absExponent < 0) {
            absExponent = -absExponent;
        }
        double result = myPowAdvanced(x, absExponent);
        if (n < 0) {
            result = 1.0D / result;
        }
        return result;
    }

    private double myPowAdvanced(double base, long exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = myPowAdvanced(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }

    private double myPow(double base, long exponent) {
        double result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }

    @Test
    public void testZero() {
        Assert.assertEquals(0, myPow(0, 12), 0.000001);
    }

    @Test
    public void test1() {
        Assert.assertEquals(1024.00000, myPow(2.00000, 10), 0.000001);
    }

    @Test
    public void test2() {
        Assert.assertEquals(9.26100, myPow(2.10000, 3), 0.000001);
    }

    @Test
    public void test3() {
        Assert.assertEquals(0.25000, myPow(2.00000, -2147483648), 0.000001);
    }
}
