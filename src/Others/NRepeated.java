package Others;

import java.util.*;

/**
 * 找出数组重复最多的数
 */

public class NRepeated {
    public int repeatedNTimes(int[] A) {
        int count  = A.length/2;
        int sum;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length - 1; i++) {
            if (map.containsKey(A[i]))  continue;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i]==A[j]){
                    if (!map.containsKey(A[i])){
                        map.put(A[i],2);
                    }else {
                        sum = map.get(A[i]) + 1;
                        map.put(A[i], sum);
                    }
                }
            }
        }
        System.out.println(map.entrySet());
        for (int i : map.keySet()){
            if (map.get(i)==count) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        NRepeated nRepeated = new NRepeated();
        int[] arr = {5,2,5,2,5,3,5,3};
//        int[] arr = {1,2,3,3};
        System.out.println(nRepeated.repeatedNTimes(arr));
    }
}
