package Leetcode.LinkedList;

/**
 * 21. 合并两个有序链表
 */
public class MergeTwoLists {
    //递归
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
    //迭代
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //前置节点
        ListNode pre = new ListNode(0);
        //复制pre指针，操作由cur指针完成，所有操作都会赋值到pre指针保存以往的状态
        ListNode cur = pre;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;

        }
        cur.next = l1 == null ? l2 : l1;

        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);

        ListNode cur = MergeTwoLists.mergeTwoLists2(l1,l2);
        System.out.println(cur);
    }
}
