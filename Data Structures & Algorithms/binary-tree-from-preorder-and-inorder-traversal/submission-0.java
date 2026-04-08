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

    int rootIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0) return null;

        TreeNode rootNode = new TreeNode(preorder[rootIdx]);
        rootIdx++;

        int rootIdxInInorder = findIndex(inorder, rootNode.val);
        int[] leftSubTree = Arrays.copyOfRange(inorder, 0, rootIdxInInorder);
        int[] rightSubTree = Arrays.copyOfRange(inorder, rootIdxInInorder+1, inorder.length);

        rootNode.left = buildTree(preorder, leftSubTree);
        rootNode.right = buildTree(preorder, rightSubTree);

        return rootNode;
    }

    int findIndex(int[] lst, int value) {
        for(int i=0; i<lst.length; i++) {
            if(lst[i] == value) return i;
        }
        return -1;
    }
}
