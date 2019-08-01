package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 905. Sort Array By Parity 按奇偶排序数组 Created by Ping on 2019/3/25.
 */
public class SortArrayByParity {
    //思路一: 遍历A，将奇偶数分别取出来，最后将奇数放在偶数后
    public int[] sortArrayByParity(int[] A) {
        List<Integer> oddnumber = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) == 0){
                even.add(A[i]);
            }else oddnumber.add(A[i]);
        }
        even.addAll(oddnumber);
        int[] res = new int[even.size()];
        for (int i = 0; i < even.size(); i++) {
            res[i] = even.get(i);
        }
        return res;
    }

    //思路二: 双指针法，左指针如果为奇数，右指针如果为偶数，则互换
    public int[] sortArrayByParity2(int[] A){
        if(A == null || A.length == 1) return A;
        int left = 0, right = A.length-1;
        while (left < right) {
            if ((A[left] & 1) == 1 && (A[right] & 1) == 0) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }else if ((A[left] & 1) == 0) {
                left++;
            }else if ((A[right] & 1) == 1) {
                right--;
            }
        }

        return A;
    }
    public static void main(String[] args) {
        int[] A = {3,1,2,4};
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        System.out.println(Arrays.toString(sortArrayByParity.sortArrayByParity2(A)));
    }
}
