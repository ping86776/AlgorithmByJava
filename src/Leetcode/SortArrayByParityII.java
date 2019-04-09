package Leetcode;

import java.util.Arrays;

/**
 * 922. Sort Array By Parity II Created by Ping on 2019/4/9.
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length - 1; i = i + 2) {
            if ((A[i] & 1) == 1) {
                while ((A[j] & 1) == 1) {   //偶数列的奇数交换奇数列上的偶数
                    j = j + 2;
                }
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        System.out.println(Arrays.toString(A));
        return A;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,4,2};
        SortArrayByParityII sortArrayByParity = new SortArrayByParityII();
        sortArrayByParity.sortArrayByParityII(arr);
    }
}
