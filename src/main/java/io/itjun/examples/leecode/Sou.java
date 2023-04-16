/**
 * 反转二叉树
 * 
 * https://leetcode.cn/problems/invert-binary-tree/
 */


public class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode() {}
 TreeNode(int val) { this.val = val; }
 TreeNode(int val, TreeNode left, TreeNode right) {
     this.val = val;
     this.left = left;
     this.right = right;
 }
}


public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 递归翻转左右子树
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
