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
        Queue<TreeNode> childNodes = new LinkedList<>();

        parentNodes.offer(root);

        while(!parentNodes.isEmpty()) {
            List<Integer> parentNodesList = new ArrayList<>();
            while(!parentNodes.isEmpty()) {
                TreeNode currentNode = parentNodes.poll();

                parentNodesList.add(currentNode.val);

                if(currentNode.left != null) childNodes.offer(currentNode.left);
                if(currentNode.right != null) childNodes.offer(currentNode.right);
            }
            
            levelOrderTraversal.add(parentNodesList);

            parentNodes = childNodes;
            childNodes = new LinkedList<>();
        }

        return levelOrderTraversal;
    }
}
