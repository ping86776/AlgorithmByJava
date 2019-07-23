package Offer.Linklist;


import Leetcode.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class PrintLinkList {
    private static List<Integer> result = new ArrayList<>();
    public static List<Integer> printListFromTailToHead(ListNode head) {
        if (head == null) return new ArrayList<>();

        Stack<ListNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();


        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        while (!stack.isEmpty()){
            ListNode p = stack.pop();
            res.add(p.val);
        }
        return res;

    }

    public static List<Integer> printListFromTailToHead2(ListNode head) {
        if (head != null){
            if (head.next != null) {
                printListFromTailToHead2(head.next);
            }
            System.out.println(head.val);
            result.add(head.val);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        List<Integer> list = PrintLinkList.printListFromTailToHead(head);
        System.out.println(list);

//        List<Integer> list = PrintLinkList.printListFromTailToHead2(head);
//        System.out.println(list);

    }
}
