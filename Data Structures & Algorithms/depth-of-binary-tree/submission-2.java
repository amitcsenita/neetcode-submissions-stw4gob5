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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Stack<Pair<TreeNode, Integer>>stack = new Stack<>();

        stack.push(new Pair<>(root, 1));
        int maxDepth = 1;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            int curDepth = pair.getValue();
            if(pair.getKey().left != null) {
                stack.push(new Pair<>(pair.getKey().left, curDepth+1));
                maxDepth = Math.max(maxDepth, curDepth+1);
            }
            if(pair.getKey().right != null) {
                stack.push(new Pair<>(pair.getKey().right, curDepth+1));
                maxDepth = Math.max(maxDepth, curDepth+1);
            }
        }
        return maxDepth;
        
    }
}


