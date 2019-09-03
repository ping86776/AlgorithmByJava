package Leetcode;

import Leetcode.LinkedList.ListNode;

/**
 * 2. 两数相加
 * 两个链表从头开始同时遍历相加
 * 尾数进位加1
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        //进位
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }


    public static void main(String[] args) {
//        ListNode head1 = new ListNode(9);
//        head1.next = new ListNode(9);
//        head1.next.next = new ListNode(9);
//        head1.next.next.next = new ListNode(9);
//        head1.next.next.next.next = new ListNode(9);
//        head1.next.next.next.next.next= new ListNode(9);
//        head1.next.next.next.next.next.next = new ListNode(9);
//        head1.next.next.next.next.next.next.next = new ListNode(9);
//        head1.next.next.next.next.next.next.next.next = new ListNode(9);
//        head1.next.next.next.next.next.next.next.next.next = new ListNode(9);
//        ListNode head2 = new ListNode(9);
//        head2.next = new ListNode(9);
//        head2.next.next = new ListNode(9);
//        head2.next.next.next = new ListNode(9);
//        head2.next.next.next.next = new ListNode(9);
//        head2.next.next.next.next.next = new ListNode(9);
//        head2.next.next.next.next.next.next = new ListNode(9);
//        head2.next.next.next.next.next.next.next = new ListNode(9);
//        head2.next.next.next.next.next.next.next.next = new ListNode(9);
//        head2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);
        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);

        System.out.println(AddTwoNumbers.addTwoNumbers2(head1,head2));

    }

}
