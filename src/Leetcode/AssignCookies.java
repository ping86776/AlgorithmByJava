package Leetcode;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * 思路：贪心算法尽量把尺寸最大的糖果留到最后
 * 具体排序两个数组，定义双指针
 * 如果饼干尺寸大于胃口，两个指针往后移动，小于则饼干指针往后移动
 * 直到指针移动到饼干或胃口数组的末尾
 */
public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int children  = 0, cookies = 0;
        while (children < g.length && cookies < s.length) {
            if (s[cookies] >= g[children]) {
                children++;
            }
            cookies++;
        }
        return children;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,1};
        System.out.println(AssignCookies.findContentChildren(g,s));
    }
}
