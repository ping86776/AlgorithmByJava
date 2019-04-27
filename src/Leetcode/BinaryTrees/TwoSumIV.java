package Leetcode.BinaryTrees;

import java.util.*;

/**
 * 653. Two Sum IV - Input is a BST Created by Ping on 2019/4/15.
 * ����һ��������������һ��Ŀ��������� BST �д�������Ԫ�������ǵĺ͵��ڸ�����Ŀ�������򷵻� true��
 */

public class TwoSumIV {
    private static List<TreeNode> nodeList = null;

    // ��ʵ���¶����������ݽṹ
    public void createBinTree(int[] arr){
        nodeList = new LinkedList<>();
        //��һ�������ֵ����ת��Ϊ�������ڵ�
        for (int i = 0; i < arr.length; i++) {
            nodeList.add(new TreeNode(arr[i]));
        }
        if (arr.length / 2 - 1 == 0){
            int parentIndex = 0;
            nodeList.get(parentIndex).left = nodeList.get(parentIndex*2+1);
            nodeList.get(parentIndex).right = nodeList.get(parentIndex*2+2);
        }
        for (int parentIndex = 0; parentIndex < arr.length / 2 - 1; parentIndex++) {
            //����
            nodeList.get(parentIndex).left = nodeList.get(parentIndex*2+1);
            //�Һ���
            nodeList.get(parentIndex).right = nodeList.get(parentIndex*2+2);

            int lastparentIndex = arr.length/2 - 1;
            //���һ�����ڵ�����
            nodeList.get(lastparentIndex).left = nodeList.get(lastparentIndex*2+1);
            //���arrΪ���������Һ���
            if ((arr.length&1)==1){
                nodeList.get(lastparentIndex).right = nodeList.get(lastparentIndex*2+2);
            }
        }
    }

    public void preOrderTraverse(TreeNode node, List<Integer> list) {
        //�������(�����Ƕ�������������������)
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
    //�ٷ����ķ���
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
        System.out.println(twoSumIV.findTarget(nodeList.get(0),4)); //���ڵ�Ϊ0
    }
}
