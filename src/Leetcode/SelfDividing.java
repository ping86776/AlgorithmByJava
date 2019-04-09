package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 728. 自除数 觉得还是这样好 Created by Ping on 2019/4/9.
 */
public class SelfDividing {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (findSelf(i)){
                list.add(i);
            }
        }
        System.out.println(list);
        return list;
    }

    public boolean findSelf(int n){
        String str = String.valueOf(n);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Integer.parseInt(String.valueOf(str.charAt(i)))==0){
                return false;
            }else {
                if (n % Integer.parseInt(String.valueOf(str.charAt(i)))==0) count++;
            }
        }
        if (count==str.length()) return true;
        return false;
    }

    public static void main(String[] args) {
        SelfDividing selfDividing = new SelfDividing();
        selfDividing.selfDividingNumbers(47,85);
    }
}
