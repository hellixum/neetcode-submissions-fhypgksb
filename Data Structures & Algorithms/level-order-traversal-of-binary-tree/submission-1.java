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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        if(root == null) return levelOrderTraversal;

        Queue<TreeNode> parentNodes = new LinkedList<>();

        parentNodes.offer(root);

        while(!parentNodes.isEmpty()) {
            List<Integer> parentNodesList = new ArrayList<>();
            int numberOfParentNodes = parentNodes.size();

            while(numberOfParentNodes > 0) {
                TreeNode currentNode = parentNodes.poll();

                parentNodesList.add(currentNode.val);

                if(currentNode.left != null) parentNodes.offer(currentNode.left);
                if(currentNode.right != null) parentNodes.offer(currentNode.right);

                numberOfParentNodes--;
            }
            
            levelOrderTraversal.add(parentNodesList);
        }

        return levelOrderTraversal;
    }
}
