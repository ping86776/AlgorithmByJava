package Offer.Tree;

import Leetcode.BinaryTrees.TreeNode;

public class RebuildTree {
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

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        TreeNode node = RebuildTree.reConstructBinaryTree(pre, in);
        System.out.println(node);
    }
}
