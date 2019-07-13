package Offer.Linklist;

import Leetcode.LinkedList.ListNode;


/**
 * 找到链表中倒数第n个结点
 */
public class TheKthNodeInTheList {
    public static ListNode FindKthToTail(ListNode head, int n){
        if (head == null || n == 0) return null;

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode node = TheKthNodeInTheList.FindKthToTail(head, 2);

        System.out.println(node);

    }
}
