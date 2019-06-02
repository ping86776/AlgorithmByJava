package Leetcode.Important;

import java.util.HashSet;

/**
 * 202. 快乐数 Created by Ping on 2019/6/2.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1){
            int res = 0;
            while(n > 0){
                int val = n % 10;   //尾数位
                res += val * val;
                n /= 10;    //不断取首位
            }
            if(set.contains(res)){
                return false;
            }
            set.add(res);
            n = res;
        }
        return true;
    }


    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(19));
    }

}
