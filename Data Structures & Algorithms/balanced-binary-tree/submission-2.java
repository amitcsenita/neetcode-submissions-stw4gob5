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


 /*
 * Balanced Binary Tree — Optimized DFS (O(n))
 *
 * 1. Each recursive call returns the actual subtree height if balanced.
 * 2. Return -1 if any subtree is unbalanced (failure signal).
 * 3. Never use -1 in height calculations; propagate it immediately.
 * 4. At each node, check abs(leftHeight - rightHeight) <= 1.
 * 5. If balanced, return 1 + max(leftHeight, rightHeight).
 * 6. Final answer: balancedHeight(root) != -1.
 *
 * Key insight: Calculate height AND check balance in one DFS traversal.
 * Time: O(n) | Space: O(h), where h is tree height.
 */

class Solution {

    int balancedHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = balancedHeight(root.left);
        if (leftHeight == -1) return -1;

         int rightHeight = balancedHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight -rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);


    }
    public boolean isBalanced(TreeNode root) {
        return balancedHeight(root) != -1;
    }
}
