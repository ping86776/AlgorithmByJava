package Offer;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 * push 动作都在 stack1 中进行，pop 动作在 stack2 中进行。
 * 当 stack2 不为空时，直接 pop，
 * 当 stack2 为空时，先把 stack1 中的元素 pop 出来，push 到 stack2 中，再从 stack2 中 pop 元素。
 */
public class ImplementQueueusingStacks {
    Stack<Object> stack1 = new Stack<>();
    Stack<Object> stack2 = new Stack<>();

    private Object node;

    public void push(Object node) {
        stack1.push(node);
    }

    public Object pop() {
        if(stack1.isEmpty() && stack2.isEmpty())
            throw new RuntimeException("Queue is empty!");
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                node = stack1.pop();
                stack2.push(node);
            }
        }

        return stack2.pop();
    }

    public Object peek(){
        if (stack1.isEmpty() && stack2.isEmpty())
            throw new RuntimeException("Queue is empty!");
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                node = stack1.pop();
                stack2.push(node);
            }
        }

        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public ImplementQueueusingStacks(){}

    public static void main(String[] args) {
        ImplementQueueusingStacks queue = new ImplementQueueusingStacks();
        queue.push(1);
        queue.push(2);
        queue.pop();
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
