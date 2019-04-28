package Leetcode.BinaryTrees;


import java.util.LinkedList;


/**
 * 二叉树深度优先搜索(栈实现)Created by Ping on 2019/4/28.
 */
public class DFS {
    //前序
    public void preOrderTraverse(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()){
            if (node!=null){
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            }else if (!stack.isEmpty()){
                node = stack.pop();
                node = node.right;
            }
        }
    }

    //前序另一种写法
    public void preOrderTraverse2(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        stack.push(node);
        while (node!=null || !stack.isEmpty()){
            node = stack.pop();
            System.out.println(node.val);
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }
    }

    //中序
    public void midOrderTraverse(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()){
            if (node!=null){
                stack.push(node);
                node = node.left;
            }else if (!stack.isEmpty()){
                TreeNode cnode = stack.pop();
                System.out.println(cnode.val);
                node = cnode.right;
            }
        }
    }

    //中序另一种写法
    public void midOrderTraverse2(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node!=null){
            if (node!=null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }
    }

    //后序
    public void underOrderTraverse(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        TreeNode node = root;
        stack.push(node);
        while (!stack.isEmpty()){
            node = stack.pop();

            stack2.push(node);  //这里以根左右的顺序入另一个栈

            if (node.left!=null){
                stack.push(node.left);
            }
            if (node.right!=null){
                stack.push(node.right);
            }
        }

        while (!stack2.isEmpty()){
            System.out.println(stack2.pop().val);   //这里出栈就是右左根的顺序了
        }

    }
}
