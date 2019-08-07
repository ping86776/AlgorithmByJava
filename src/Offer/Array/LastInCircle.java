package Offer.Array;


import java.util.LinkedList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字
 * 利用环形链表
 */
public class LastInCircle {
    //方法一: 设置一个指针p来记录每次删除的数在链表的位置
    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) return -1;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) list.add(i);

        int p = 0;
        while (list.size() > 1) {
            for (int i = 0; i < m - 1; i++) {
                p++;
                //遍历到链表末尾时重置指针
                if (p == list.size()) p = 0;
            }
            list.remove(p);
            // 删除的正好是链表的最后一个元素(防止越界)
            if (p == list.size()) p = 0;

        }

        return list.get(0);
    }

    //方法2利用取余操作自动解决了到链表尾部时需要转到下标0的问题
    public static int lastRemaining2(int n, int m) {
        if (n < 1 || m < 1) return -1;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) list.add(i);

        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        int a = LastInCircle.lastRemaining2(5,3);
        System.out.println(a);
    }
}
