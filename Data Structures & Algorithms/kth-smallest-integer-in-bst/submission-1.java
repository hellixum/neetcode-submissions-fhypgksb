/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int ans;
    int index;

    public int kthSmallest(TreeNode root, int k) {
        index = k;
        inorderTravel(root);
        return ans;
    }

    void inorderTravel(TreeNode root) {
        if(root == null || index < 1) return ;
        inorderTravel(root.left);

        if(index == 1) ans = root.val;
        index--;

        inorderTravel(root.right);
    }
}
