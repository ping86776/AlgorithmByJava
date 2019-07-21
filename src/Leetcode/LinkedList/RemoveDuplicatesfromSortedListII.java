package Leetcode.LinkedList;

public class RemoveDuplicatesfromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        //为了防止第一个数开始的重复，如果不设置前置节点，second指针就会以第二个开始，第一个就不会删除了
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode first = pre;
        ListNode second = first.next;

        while (second != null) {
            if (second.next != null && second.val == second.next.val) {
                while (second.next != null && second.val == second.next.val){
                    second = second.next;
                }
                first.next = second.next;
            }else {
                first = first.next;
            }

            second = second.next;
        }

        return pre.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(3);
//        l1.next.next.next.next.next = new ListNode(4);
        ListNode node = RemoveDuplicatesfromSortedListII.deleteDuplicates(l1);
        System.out.println(node);
    }
}
