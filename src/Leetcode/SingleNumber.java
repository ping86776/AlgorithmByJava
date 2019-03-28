package Leetcode;

/**
 * Created by Ping on 2019/3/8.
 */


import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 136 Single Number 给定一个整数数组，除了一个元素外，每个元素都会出现两次。 找出单一的那个。
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            map.put(i,A[i]);
        }
        for (int i = 0; i < A.length-1; i++) {
            for (int j = i+1; j < A.length; j++){
                if (A[i]==A[j]){
                    map.remove(i);
                    map.remove(j);
                }
            }
        }
        Collection<Integer> res = map.values();
        Iterator<Integer> iter = res.iterator();
        return iter.next();
    }
    // 最优方法利用异或的性质
    public int Best(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res ^= A[i];
        }
        return res;
    }

        public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();
        int[] p = {1,0,3,0,1};

        System.out.println(solution.Best(p));
    }
}
