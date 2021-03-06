package Leetcode.LinkedList;

/**
 * 199.删除链表的倒数第N个节点
 */
public class RemoveNthNodeFromEndofList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode fast = pre;
        ListNode slow = pre;

        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return pre.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode node = RemoveNthNodeFromEndofList.removeNthFromEnd(head, 2);
        System.out.println(node);
    }
}
