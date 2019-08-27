package Offer.Array;

public class UglyNumber {
    public static int uglyNumber(int n) {
        if (n <= 0) return 0;
        //三个指针
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        int[] res = new int[n];
        // 第一个丑数为1
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            int m2 = res[t2] * 2;
            int m3 = res[t3] * 3;
            int m5 = res[t5] * 5;
            // 三个候选中最小的就是下一个丑数
            res[i] = Math.min(m2, Math.min(m3, m5));
            // 选择某个丑数后ti * i，指针右移从丑数集合中选择下一个丑数和i相乘，注意是三个连续的if，也就是三个if都有可能执行。
            // 这种情况发生在三个候选中有多个最小值，指针都要右移，不然会存入重复的丑数
            if (res[i] == m2) t2++;
            if (res[i] == m3) t3++;
            if (res[i] == m5) t5++;
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        UglyNumber.uglyNumber(5);
    }
}
