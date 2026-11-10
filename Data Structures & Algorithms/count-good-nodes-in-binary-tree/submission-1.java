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
    public int goodNodes(TreeNode root) {
       if (root == null) return 0; 
       Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
       queue.offer(new Pair<>(root, Integer.MIN_VALUE));
       int goodNodesCount = 0;

        while (!queue.isEmpty()) {
           Pair<TreeNode, Integer> pair = queue.poll();
           TreeNode currentNode = pair.getKey();
           int maxValueAtNode = pair.getValue();
           if (currentNode.val >= maxValueAtNode) {
             goodNodesCount++;
           }

           int maxValueForChild = Math.max(maxValueAtNode, currentNode.val);
           TreeNode leftNode = currentNode.left;
           TreeNode rightNode = currentNode.right;

           if (leftNode != null) {
             queue.offer(new Pair<>(leftNode, maxValueForChild));
           }
           
           if (rightNode != null) {
             queue.offer(new Pair<>(rightNode, maxValueForChild));
           }      
        }
        return goodNodesCount;
    }
}
