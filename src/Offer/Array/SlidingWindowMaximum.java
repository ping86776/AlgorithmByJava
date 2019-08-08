package Offer.Array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 滑动窗口的最大值
 */
public class SlidingWindowMaximum {
    //暴力遍历每个滑动窗口得到的最大值
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];

        int [] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;

    }

    //双向队列
    /**
     * 队列第一个位置保存当前窗口的最大值，当窗口滑动一次，判断当前最大值是否过期（当前最大值的位置是不是在窗口之外），
     * 新增加的值从队尾开始比较，把所有比他小的值丢掉。这样时间复杂度为O(n)。
     * 返回输出数组。
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;
        // 特判
        if (len == 0) {
            return new int[]{};
        }
        // 结果集
        List<Integer> res = new ArrayList<>();
        // 滑动窗口，注意：保存的是索引值
        ArrayDeque<Integer> deque = new ArrayDeque<>(k);

        for (int i = 0; i < len; i++) {
            // 当元素从左边界滑出的时候，如果它恰恰好是滑动窗口的最大值
            // 那么将它弹出
            if (i >= k && i - k == deque.getFirst()) {
                deque.pollFirst();
            }

            // 如果滑动窗口非空，新进来的数比队列里已经存在的数还要大
            // 则说明已经存在数一定不会是滑动窗口的最大值
            // 将它们弹出
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            // 队首一定是滑动窗口的最大值的索引,这里只是判断是否为队首
            if (i >= k - 1) {
                res.add(nums[deque.peekFirst()]);
            }
        }

        int size = res.size();
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        int[] arr2 = new int[]{1,-1};

        int[] res = SlidingWindowMaximum.maxSlidingWindow2(arr,2);
        System.out.println(Arrays.toString(res));
    }
}
