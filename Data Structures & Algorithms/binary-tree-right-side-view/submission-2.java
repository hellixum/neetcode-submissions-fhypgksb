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
    public List<Integer> rightSideView(TreeNode root) {

        if(root == null) return new ArrayList<>();
        
        Queue<TreeNode> levelOrderTraversal = new LinkedList<>();
        List<Integer> rightViewOfTree = new ArrayList<>();

        levelOrderTraversal.offer(root);

        while(!levelOrderTraversal.isEmpty()) {
            int levelSize = levelOrderTraversal.size();

            TreeNode currentNode = levelOrderTraversal.peek();
            rightViewOfTree.add(currentNode.val);

            while(levelSize > 0) {
                currentNode = levelOrderTraversal.poll();
                if(currentNode.right != null) levelOrderTraversal.offer(currentNode.right);
                if(currentNode.left != null) levelOrderTraversal.offer(currentNode.left);

                levelSize--;
            }
        }

        return rightViewOfTree;
    }
}
