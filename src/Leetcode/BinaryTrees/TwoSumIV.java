package Leetcode.BinaryTrees;

import java.util.*;

/**
 * 653. Two Sum IV - Input is a BST Created by Ping on 2019/4/15.
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 */

public class TwoSumIV {
    private static List<TreeNode> nodeList = null;

    // 简单实现下二叉树的数据结构
    public void createBinTree(int[] arr){
        nodeList = new LinkedList<>();
        //将一个数组的值依次转换为二叉树节点
        for (int i = 0; i < arr.length; i++) {
            nodeList.add(new TreeNode(arr[i]));
        }
        if (arr.length / 2 - 1 == 0){
            int parentIndex = 0;
            nodeList.get(parentIndex).left = nodeList.get(parentIndex*2+1);
            nodeList.get(parentIndex).right = nodeList.get(parentIndex*2+2);
        }
        for (int parentIndex = 0; parentIndex < arr.length / 2 - 1; parentIndex++) {
            //左孩子
            nodeList.get(parentIndex).left = nodeList.get(parentIndex*2+1);
            //右孩子
            nodeList.get(parentIndex).right = nodeList.get(parentIndex*2+2);

            int lastparentIndex = arr.length/2 - 1;
            //最后一个父节点左孩子
            nodeList.get(lastparentIndex).left = nodeList.get(lastparentIndex*2+1);
            //如果arr为奇数才有右孩子
            if ((arr.length&1)==1){
                nodeList.get(lastparentIndex).right = nodeList.get(lastparentIndex*2+2);
            }
        }
    }

    public void preOrderTraverse(TreeNode node, List<Integer> list) {
        //中序遍历(这是是二叉搜索树所以用中序)
        if (node == null)
            return ;
        preOrderTraverse(node.left, list);
        list.add(node.val);
        preOrderTraverse(node.right,list);
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        preOrderTraverse(root, list);
        int i = 0;
        int j = list.size()-1;
        while (i<j){
            int value = list.get(i)+list.get(j);
            if (value==k) {
                return true;
            }else if (value<k){
                i++;
            }else j--;
        }
        return false;
    }
    //官方给的方法
//    public boolean findTarget(TreeNode root, int k) {
//        Set < Integer > set = new HashSet();
//        return find(root, k, set);
//    }
//    public boolean find(TreeNode root, int k, Set < Integer > set) {
//        if (root == null)
//            return false;
//        if (set.contains(k - root.val))
//            return true;
//        set.add(root.val);
//        return find(root.left, k, set) || find(root.right, k, set);
//    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        TwoSumIV twoSumIV = new TwoSumIV();
        twoSumIV.createBinTree(arr);
        System.out.println(twoSumIV.findTarget(nodeList.get(0),4)); //根节点为0
    }
}
