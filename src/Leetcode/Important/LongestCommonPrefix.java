package Leetcode.Important;

/**
 * 14. Longest Common Prefix Created by Ping on 2019/4/29.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {  //根据最初的词缀水平往后查，这里等于0就是前缀和此时的strs[i]相等
                prefix = prefix.substring(0, prefix.length() - 1); //最后一位减
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)    //根据第一个数的第i个前缀一个一个和后面的数的第i个前缀比
                    return strs[0].substring(0, i);     //直到第i个前缀和第一个数的i个前缀不同了，截取相同的前缀部分返回
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] str = new String[]{"dog","racecar","car"};
        LongestCommonPrefix l = new LongestCommonPrefix();
        System.out.println(l.longestCommonPrefix2(str));

    }
}
