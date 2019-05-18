package Leetcode.Important;


import java.util.*;


/**
 *  88. Merge Sorted Array
 *  合并两个有序数组
 *  Created by Ping on 2019/4/30.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        for (int i = m; i < nums1.length; i++) {
//            nums1[i] = nums2[i-m];
//        }
//        Arrays.sort(nums1);

        // 初始化两个指针,从后往前填充
        int i = m - 1, j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            if (i < 0){   // 数组1的元素使用完毕
                nums1[k] = nums2[j];
                j--;
            }else if (j < 0){
                break;          // 数组2的元素使用完毕,只剩数组1的元素,就不必继续了
            }else if (nums2[j] > nums1[i]){
                nums1[k] = nums2[j];
                j--;
            }else {
                nums1[k] = nums1[i];
                i--;
            }

        }

        System.out.println(Arrays.toString(nums1));
    }


    public static void main(String[] args) {
        MergeSortedArray m = new MergeSortedArray();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        m.merge(nums1,3, nums2,3);
    }
}
