package Leetcode.BinaryTrees;


import java.util.LinkedList;


/**
 * �����������������(ջʵ��)Created by Ping on 2019/4/28.
 */
public class DFS {
    //ǰ��
    public void preOrderTraverse(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()){
            if (node!=null){
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            }else if (!stack.isEmpty()){
                TreeNode cnode = stack.pop();
                node = cnode.right;
            }
        }
    }

    //����
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

    //����ûŪ��
}
