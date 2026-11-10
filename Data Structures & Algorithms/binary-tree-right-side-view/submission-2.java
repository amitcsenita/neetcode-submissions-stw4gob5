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
        List<Integer> rightSideValues = new ArrayList<>();
        collectRightmostNodes(root, 0, rightSideValues);
        return rightSideValues;
    }

    private void collectRightmostNodes(TreeNode currentNode,
                                       int currentDepth,
                                       List<Integer> rightSideValues) {
        if (currentNode == null) {
            return;
        }

        // First node visisted at this depth
        if (currentDepth == rightSideValues.size()) {
            rightSideValues.add(currentNode.val);
        }    

        collectRightmostNodes(currentNode.right, currentDepth + 1, rightSideValues);
        collectRightmostNodes(currentNode.left, currentDepth + 1, rightSideValues);  
        
    }
}
