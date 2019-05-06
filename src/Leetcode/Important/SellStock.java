package Leetcode.Important;

/**
 * 121. Best Time to Buy and Sell Stock
 * 思路是找数组的峰值，时间复杂度O(n)
 * Created by Ping on 2019/5/6.
 */
public class SellStock {
    public int maxProfit(int prices[]) {
        if(prices.length==0) return 0;
        int minprice = prices[0];
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        SellStock s = new SellStock();
        int[] arr = new int[]{7,1,5,3,6,4};
        int[] arr2 = new int[]{1,3,2};
        int[] arr3 = new int[]{};

        System.out.println(s.maxProfit(arr3));
    }
}
