package Offer.Tree;

import Leetcode.BinaryTrees.TreeNode;

/**
 * 重建二叉树
 */
public class ReConstructBinaryTree {
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return construct(pre, in, 0, 0, in.length-1);
    }

    private static TreeNode construct(int[] pre,int[] in,int prestart,int instart,int inend){
        if (instart > inend) return null;

        TreeNode root = new TreeNode(pre[prestart]);//存入根节点

        for (int i = instart; i <= inend; i++) {
            if (in[i] == pre[prestart]) {
                root.left = construct(pre, in, prestart+1, instart, i-1);
                root.right = construct(pre, in, prestart+i-instart+1, i+1, inend);
            }
        }

        return root;
    }


    //重建遍历序列实现
    public static TreeNode reConstructBinaryTree2 (int [] pre,int [] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);

        //左子树的个数
        int leftNum = 0;
        for (int i = 0; i < in.length; i++) {
            if (root.val == in[i]){
                break;
            }else {
                leftNum++;
            }
        }

        //右子树的个数
        int rightNum = in.length - 1 - leftNum;
        //重建左子树
        if (leftNum > 0) {
            //左子树先序序列
            int[] leftpreOrder = new int[leftNum];
            int[] leftinOrder = new int[leftNum];


            for (int i = 0; i < leftNum; i++) {
                leftpreOrder[i] = pre[i + 1];
                leftinOrder[i] = in[i];
            }

            root.left = reConstructBinaryTree2(leftpreOrder, leftinOrder);
        }

        //重建右子树
        if (rightNum > 0) {
            int[] rightpreOrder = new int[rightNum];
            int[] rightinOrder = new int[rightNum];

            for (int i = 0; i < rightNum; i++) {
                rightpreOrder[i] = pre[leftNum + 1 + i];
                rightinOrder[i] = pre[leftNum + 1 + i];
            }

            root.right = reConstructBinaryTree2(rightpreOrder, rightinOrder);
        }

        return root;

    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        TreeNode node = ReConstructBinaryTree.reConstructBinaryTree2(pre, in);
        System.out.println(node);
    }
}
