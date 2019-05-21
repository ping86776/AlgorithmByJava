package Leetcode.LinkedList;

/**
 *  160 相交链表 Created by Ping on 2019/5/21.
 */
public class IntersectionofTwoLinkedLists {
    //方法一 求两个链表的长度差，先遍历长的，然后同时遍历找到第一个相等的
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p = headA;
        ListNode q = headB;

        int l1 = 0 ,l2 = 0;
        while (p.next!=null){
            l1 ++;
            p = p.next;
        }
        while (q.next!=null){
            l2 ++;
            q = q.next;
        }
        int len = 0;
        //重新调整链表遍历的节点位置
        p = headA;
        q = headB;
        if (l1 > l2){
            len = l1 - l2;
            while (len!=0){
                p = p.next;
                len--;
            }
        }else {
            len = l2 - l1;
            while (len!=0){
                q = q.next;
                len--;
            }
        }


        while (p != q){
            p = p.next;
            q = q.next;
        }
        return p;

    }
}
