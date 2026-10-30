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
    public TreeNode invertTree(TreeNode root) {
         if (root == null) return null;

        Stack<TreeNode> dfsStack = new Stack<>();
        dfsStack.push(root);
        while (!dfsStack.isEmpty()) {
           TreeNode node = dfsStack.pop();
           TreeNode temp = node.left;
           node.left = node.right;
           node.right = temp;
           if (node.left != null) {
             dfsStack.push(node.left);
           }
           if (node.right != null) {
             dfsStack.push(node.right);
           }
        }   
        return root;     
        
    }
}
