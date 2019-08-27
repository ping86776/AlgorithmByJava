package Offer.Array;

public class MaxProductAfterCutting {
    public static int maxProductAfterCutting(int length) {
        if (length < 2) return 0;
        if (length == 2) return 1;  //f(2) = 1
        if (length == 3) return 2;  //f(3) = 2

        // 加1是因为需要访问到products[length]
        int[] products = new int[length + 1];
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        for (int i = 4; i < length; i++) {
            int max = 0;

            // 对所有相乘情况进行遍历求出f(i)的最优解
            for (int j = 1; j <= i / 2; j++) {
                int cur = products[j] * products[i - j];
                if (cur > max) {
                    max = cur;
                }
            }
            // 得到f(i)的最优解
            products[i] = max;
        }

        // 返回f(n)
        return products[length];
    }

    public static void main(String[] args) {
        int val = MaxProductAfterCutting.maxProductAfterCutting(5);
        System.out.println(val);
    }
}
