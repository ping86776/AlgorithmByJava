package Offer.Array;

/**
 * 数组中重复的数字 返回任意重复的一个
 */
public class DuplicateNums {
    public static int duplicate(int[] numbers) {
        if (numbers.length == 0) return -1;
        int duplication = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == numbers[numbers[i]]) {
                duplication = numbers[i];
                return duplication;
            }else {
                int temp = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,0,2,5,3};
        int target = DuplicateNums.duplicate(arr);
        System.out.println(target);
    }
}
