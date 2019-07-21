package Leetcode.LinkedList;

public class RemoveDuplicatesfromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        ListNode node = RemoveDuplicatesfromSortedList.deleteDuplicates(l1);
        System.out.println(node);

    }
}
