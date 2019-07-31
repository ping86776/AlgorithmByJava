package Leetcode.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈(一个队列实现)
 * 思路：在push的时候就调换位置
 */
public class ImplementStackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<>();

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
        int size = q1.size();
        while (size > 1){
            q1.offer(q1.poll());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues mystack = new ImplementStackUsingQueues();
        mystack.push(1);
        mystack.push(2);
        System.out.println(mystack.q1);
        System.out.println(mystack.pop());
//        System.out.println(mystack.top());
    }
}
