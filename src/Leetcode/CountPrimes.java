package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 204.统计所有小于非负整数 n 的质数的数量。
 * 质数不能被它本身和1以外的数整除
 */
public class CountPrimes {
    //厄拉多塞筛法（时间最优）
    //选中数字2删除2的倍数，选中数字3删除3的倍数，选中数字5删除5的倍数
    public static int countPrimes(int n) {
        int count = 0;
        boolean[] signs = new boolean[n];
        System.out.println(Arrays.toString(signs));
        for (int i = 2; i < n; i++)
        {
            //sign[i]默认为false
            if (!signs[i])
            {
                count++;
                for (int j = i * 2; j < n; j += i)
                {
                    //非质数的数其为下标对应的值为真。
                    signs[j] = true;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int n = CountPrimes.countPrimes(10000);
        System.out.println(n);
        String a = "a";
        a.hashCode();
    }
}
