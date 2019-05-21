package Leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表 Created by Ping on 2019/5/19.
 */
public class LinkedListCycle {
    //哈希表遍历链表判断head节点是否被引用
    public boolean hasCycle(ListNode head) {
        Set<ListNode> node = new HashSet<>();
        while(head!=null){
            if(node.contains(head)){
                return true;
            }else{
                node.add(head);
            }
            head = head.next;
        }

        return false;
    }

    //快慢双指针
    public boolean hasCycle2(ListNode head){
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != slow){
            //如果不存在环，快指针遍历完链表输出false
            if (fast == null || fast.next == null) return false;
            //只有在环中，快指针才会和慢指针相遇
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        LinkedListCycle l = new LinkedListCycle();
        System.out.println(l.hasCycle(head));
    }
}
