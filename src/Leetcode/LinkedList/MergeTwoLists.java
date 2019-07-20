package Leetcode.LinkedList;

public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;


        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(6);
        l2.next = new ListNode(7);
        l2.next.next = new ListNode(8);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(10);

        ListNode cur = MergeTwoLists.mergeTwoLists(l1,l2);
        System.out.println(cur);
    }
}
