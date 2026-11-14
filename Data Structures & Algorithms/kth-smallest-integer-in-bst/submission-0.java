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
        TreeNode currentNode = root;
        int visitedNodesCount = 0;
        TreeNode nextSmallestNode = null;

        while (currentNode != null || !traversalStack.isEmpty()) {
           while (currentNode != null) {
             traversalStack.push(currentNode);
             currentNode = currentNode.left;
           }

           nextSmallestNode = traversalStack.pop();
           visitedNodesCount++;

           if (visitedNodesCount == k) {
            return nextSmallestNode.val;
           }

           currentNode = nextSmallestNode.right;

        }

        return -1;
        
    }
}
