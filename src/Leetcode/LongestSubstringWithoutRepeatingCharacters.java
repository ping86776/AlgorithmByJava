package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * HashSet设为滑动窗口
 * 定义快慢指针
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int slow = 0, fast = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (slow < s.length() && fast < s.length()) {
            if (!set.contains(s.charAt(fast))) {
                set.add(s.charAt(fast));
                fast++;
                max = max > fast - slow ? max : fast - slow;
            } else {
                //去除重复的，窗口往后滑动
                set.remove(s.charAt(slow));
                slow++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(str));
    }
}
