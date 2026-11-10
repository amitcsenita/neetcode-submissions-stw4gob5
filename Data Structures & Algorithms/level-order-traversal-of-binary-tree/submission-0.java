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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> levels = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int lastLevelLen = queue.size();
            List<Integer> level = new ArrayList<>(); 
            for (int i = 0 ; i < lastLevelLen ; i++) {
                TreeNode currentNode = queue.poll();
                level.add(currentNode.val);
                if (currentNode.left != null) {
                   queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                   queue.offer(currentNode.right);
                }
            } 
            levels.add(level);   
        }
        return levels;
    }
}
