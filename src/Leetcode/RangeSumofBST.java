package Leetcode;

/**
 * 938. Range Sum of BST Created by Ping on 2019/4/15.
 * ����� L <= val <= R �����нڵ���ܺͣ������� 1 �� 32 = 7 + 10 + 15��ֵΪ10�Ľ���Ǵ���L��R֮��Ľ�㣻
 * �������������ص�Ϊ������������Ϊ��, �������������н�㶼С�ڸ��ڵ�; ����������Ϊ��, �������������н�㶼���ڸ��ڵ㡣
 */
public class RangeSumofBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        if(root.val >= L && root.val <= R){
            //���ý���ֵ val ���� L �� R ֮�䣬�򽫸�ֵ������
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }else if(root.val < L){
            //�� val < L�����ݶ������������ص㣬�ý����ұ߿��ܴ��ڷ���������ֵ��������Ѱ�ý����ұ�
            return rangeSumBST(root.right, L, R);
        }else {
            //�� val > R���ý�����߿��ܴ��ڷ���������ֵ��������Ѱ�ý�����ߡ�
            return rangeSumBST(root.left, L, R);
        }
    }
}
