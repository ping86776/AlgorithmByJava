package Others;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 每个输入包含两行。第一行是预算上限。第二行是用空格分隔的一组数字，代表每种物品的价格。所有数字都为正整数并且不会超过10000。
 * 不超过预算 算出总价值最大的值
 * Created by Ping on 2019/4/22.
 */
public class DPbuy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = Integer.parseInt(in.nextLine());    //背包容量
        String[] str = in.nextLine().split(" ");
        int N = str.length;     //物品数量

        int[] w = new int[N];   //每个物品的重量
        for (int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(str[i]);
        }

        int[] f = new int[10000];     //f[j]表示重量不超过j公斤的最大价值 长度就是M即背包容量
        int[] value = new int[N];   //每个物品的价值
        for (int i = 0; i < N; i++) {   //这里价值和重量一样
            value[i] = w[i];
        }
        for (int i = 0; i < N; i++) {
            for (int j = M; j >= w[i] ; j--) {    //M是背包容量，w[i]是第i个物品的重量 value[i]是每个物品的价值
                f[j] =  Math.max(f[j - w[i]] + value[i], f[j]);
            }
        }
        System.out.println(f[M]);
        System.out.println(f.length);

    }
}
