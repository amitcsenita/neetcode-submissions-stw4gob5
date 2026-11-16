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
    private int globalMaxPathSum;   
    
    public int maxPathSum(TreeNode root) {
        globalMaxPathSum = Integer.MIN_VALUE;
        maxPathHelper(root);
        return globalMaxPathSum;
    }

    // returns maxpathSum among all possible paths with subtree originating with currentNode as root
    public int maxPathHelper(TreeNode currentNode) {
        if (currentNode == null) return 0;

        int lefSubtreeMaxPathSum = Math.max(0, maxPathHelper(currentNode.left));
        int rightSubtreeMaxPathSum = Math.max(0, maxPathHelper(currentNode.right));

        int pathSumThroughCurrentNode = currentNode.val + lefSubtreeMaxPathSum + rightSubtreeMaxPathSum;

        int currentNodeMaxPathSum = currentNode.val + Math.max(lefSubtreeMaxPathSum, rightSubtreeMaxPathSum);

        globalMaxPathSum = Math.max(pathSumThroughCurrentNode, globalMaxPathSum);

        return currentNodeMaxPathSum;

    }
}
