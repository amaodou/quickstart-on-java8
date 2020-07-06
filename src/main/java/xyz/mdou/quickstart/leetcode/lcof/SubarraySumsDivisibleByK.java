package xyz.mdou.quickstart.leetcode.lcof;

public class SubarraySumsDivisibleByK {

    private static int[] A = {};
    private static int K = 586;

    public static void main(String[] args) {
        SubarraySumsDivisibleByK task = new SubarraySumsDivisibleByK();
        long l = System.currentTimeMillis();
        System.out.println(task.subarraysDivByK(A, K));
        System.out.println(System.currentTimeMillis() - l);
    }

    // 遍历起点和终点，求起点到终点元素的和，判断是否能被k整除
    public int subarraysDivByK(int[] A, int K) {
        int count = 0;
        int length = A.length;
        int[] ijSum = new int[length];
        for (int x = 0; x < length; x++) {
            if (x == 0) {
                ijSum[x] = A[0];
            } else {
                ijSum[x] = ijSum[x - 1] + A[x];
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (i == 0) {
                    if (ijSum[j] % K == 0) {
                        count += 1;
                    }
                } else {
                    if ((ijSum[j] - ijSum[i - 1]) % K == 0) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }
}
