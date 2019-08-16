package Offer.Array;

/**
 *一个整型数组里除了两个数字之外，其他的数字都出现了两次,找出出现一次的数字
 * 思路：异或数组，剩下两个出现一次的数字想异或，找出异或后的数字的最高位1(设为m位)的索引
 * 则两个出现一次的数字在m位的二进制一定一个是0一个是1，按m位是否为1必定分成两个数组，然后两个数组异或分别求出
 */
public class SingleNumber {
    public static void singleNumber(int[] arr, int num1[], int num2[]) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp ^= arr[i];
        }

        int index = firstIndex(temp);
        for (int i = 0; i < arr.length; i++) {
            if (isFirstIndex(arr[i], index)) {
                num1[0] ^= arr[i];
            }else
                num2[0] ^= arr[i];
        }

        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    /**
     * 找到两个只出现一次相异或值的最高位1的索引
     * @param val
     * @return
     */
    public static int firstIndex(int val) {
        int index = 0;
        for (int i = 0; i < 32; i++) {
            if ((val & 1) == 1) return index;
            val >>= 1;
            index++;
        }
        return index;
    }

    /**
     *
     * @param val
     * @param index
     * @return
     */
    public static boolean isFirstIndex(int val, int index) {
        return ((val >> index) & 1) == 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        SingleNumber.singleNumber(arr, num1, num2);
    }
}
