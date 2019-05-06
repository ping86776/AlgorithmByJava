package Leetcode.Important;


/**
 *  122. Best Time to Buy and Sell Stock II
 *  贪心算法
 *  Created by Ping on 2019/5/6.
 */
public class SellStockII {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i+1]-prices[i]>0){
                max += prices[i+1]-prices[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        SellStockII s = new SellStockII();
        int[] arr = new int[]{7,1,5,3,6,4};
        int[] arr2 = new int[]{7,6,5,4,3,2,1};
        int[] arr3 = new int[]{};

        System.out.println(s.maxProfit(arr2));
    }
}
