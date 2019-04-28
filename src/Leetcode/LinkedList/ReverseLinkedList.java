package Leetcode.LinkedList;

/**
 * 206. Reverse Linked List Created by Ping on 2019/4/28.
 * 主要思想是将链表前指针和后指针分别存临时变量，当前指针的next赋值为前指针，前指针赋值为当前指针，当前指针赋值为next指针
 */
public class ReverseLinkedList {
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
}
