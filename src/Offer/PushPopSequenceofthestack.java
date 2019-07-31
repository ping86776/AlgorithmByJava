package Offer;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * 将原数列依次压栈，把栈顶元素与所给出栈队列相比，如果相同则出栈，如果不同则继续压栈，直到原数列中所有数字压栈完毕。
 * 最后，检测栈中是否为空，若空，说明出栈队列可由原数列进行栈操作得到。否则，说明出栈队列不能由原数列进行栈操作得到。
 */
public class PushPopSequenceofthestack {
    public static boolean isPopOrder(int [] pushA,int [] popA) {
        if (pushA.length != popA.length) return false;

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] push = new int[]{1,2,3,4,5};
        int[] pop = new int[]{5,3,4,2,1};

        boolean flag = PushPopSequenceofthestack.isPopOrder(push, pop);
        System.out.println(flag);
    }
}
