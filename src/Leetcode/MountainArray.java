package Leetcode;

/**
 * 852. Peak Index in a Mountain Array Created by Ping on 2019/4/9.
 */
public class MountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i]>=A[max]){
                max = i;
            }
        }
        System.out.println(A[max]);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,10,5,2};
        MountainArray mountainArray = new MountainArray();
        mountainArray.peakIndexInMountainArray(arr);
    }
}
