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
        if (root == null) return rightSideValues;
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            TreeNode rightmostNode = null;

            for (int nodeIndex = 0; nodeIndex < currentLevelSize; nodeIndex++) {
                TreeNode currentNode = queue.poll();
                rightmostNode = currentNode;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            rightSideValues.add(rightmostNode.val);
        }
        return rightSideValues;
    }
}
