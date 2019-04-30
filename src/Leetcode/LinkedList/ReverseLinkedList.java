package Leetcode.LinkedList;

/**
 * 206. Reverse Linked List Created by Ping on 2019/4/28.
 *
 */
public class ReverseLinkedList {
    //遍历实现
    //主要思想是将链表前指针和后指针分别存临时变量，
    //当前指针的next赋值为前指针，前指针赋值为当前指针，当前指针赋值为next指针
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode NextTemp = cur.next;   //
            cur.next = pre;
            pre = cur;
            cur = NextTemp;
        }
        return pre;
    }

    //递归实现
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = reverseList2(head.next);

        //这里只需要考虑要交换的两个数，递归只是重复一个函数
        head.next.next = head;
        head.next = null;

        return cur;


    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l1;
        if(l2==null) return l2;
        ListNode temp = l1.next;
        l1.next = l2.next;

        mergeTwoLists(l1.next,l2.next);

        return l1;
    }
}
