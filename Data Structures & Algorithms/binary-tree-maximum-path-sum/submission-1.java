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

    // Best complete path sum found anywhere in the tree
    private int maximumPathSum;

    public int maxPathSum(TreeNode root) {

        // A non-empty path may have a negative sum
        maximumPathSum = Integer.MIN_VALUE;
        calculateDownwardGain(root);

        return maximumPathSum;
    }

     /**
     * Returns the maximum sum of a downward path that:
     * 1. Starts at currentNode.
     * 2. Follows at most ONE child branch.
     *
     * Also updates maximumPathSum using a complete path
     * that may include BOTH child branches.
     */

    private int calculateDownwardGain(TreeNode currentNode) {
        if (currentNode == null) { 
            return 0;
        }

        // STEP 1: Obtain the best useful gain from each child.
        // Ignore negative gains because they reduce the path sum.
        int leftDownwardGain = Math.max(0, calculateDownwardGain(currentNode.left));

        int rightDownwardGain = Math.max(0, calculateDownwardGain(currentNode.right));

         // STEP 2: Evaluate the complete path turning at this node.
        // A complete path may combine BOTH child branches.

        int pathSumThroughCurrentNode = currentNode.val + leftDownwardGain + rightDownwardGain;

        // STEP 3: Track the best complete path anywhere in the tree.
        maximumPathSum = Math.max(
            maximumPathSum,
            pathSumThroughCurrentNode
        );

        // STEP 4: Return the best extendable path to the parent.
        // Only ONE child branch can be included.
        int bestGainToParent =
            currentNode.val + Math.max(leftDownwardGain, rightDownwardGain);


       return bestGainToParent;

    }
}
