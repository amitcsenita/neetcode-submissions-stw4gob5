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
    public boolean isValidBST(TreeNode root) {  
        return validateSubtree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validateSubtree(TreeNode currentNode, long lowerBound, long upperBound) {
        if (currentNode == null) {
          return true;
        }

        if (currentNode.val <= lowerBound || currentNode.val >= upperBound) {
            return false;
        }

         boolean isValidLeftSubtree = validateSubtree(currentNode.left, lowerBound, (long)currentNode.val);
         boolean isValidRightSubtree = validateSubtree(currentNode.right, currentNode.val, (long)upperBound);

         return isValidLeftSubtree && isValidRightSubtree;

    }
}
