
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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> traversalStack = new ArrayDeque<>();
        TreeNode nodeToExplore = root;
        int visitedCount = 0;
        

        while (nodeToExplore != null || !traversalStack.isEmpty()) {
           while (nodeToExplore != null) {
             traversalStack.push(nodeToExplore);
             nodeToExplore = nodeToExplore.left;
           }

           TreeNode nodeToVisit = traversalStack.pop();
           visitedCount++;

           if (visitedCount == k) {
            return nodeToVisit.val;
           }

           nodeToExplore = nodeToVisit.right;

        }

        return -1;
        
    }
}
