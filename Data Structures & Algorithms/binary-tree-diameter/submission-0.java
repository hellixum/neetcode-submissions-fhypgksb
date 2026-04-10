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

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDistanceToLeaf(root);
        return maxDiameter; 
    }

    int maxDistanceToLeaf(TreeNode root) {
        if(root == null) return 0;

        int leftDistance = maxDistanceToLeaf(root.left);
        int rightDistance = maxDistanceToLeaf(root.right);

        maxDiameter = Math.max(leftDistance+rightDistance, maxDiameter);


        return 1 + Math.max(leftDistance , rightDistance);
    }
}
