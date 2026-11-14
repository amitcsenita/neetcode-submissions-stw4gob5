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
    private int nextPreorderIndex;
    private Map<Integer, Integer> inorderIndexByValue;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
       nextPreorderIndex = 0;
       inorderIndexByValue = new HashMap<>();

       for (int index = 0; index < inorder.length; index++) {
         inorderIndexByValue.put(inorder[index], index);
       }
       return buildSubtree(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildSubtree(int[] preorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        int rootValue = preorder[nextPreorderIndex++];
        TreeNode subtreeRoot = new TreeNode(rootValue);
        int rootInorderIndex = inorderIndexByValue.get(rootValue);
         
        subtreeRoot.left = buildSubtree(preorder, inorderStart, rootInorderIndex - 1);
        subtreeRoot.right = buildSubtree(preorder, rootInorderIndex + 1, inorderEnd);

        return subtreeRoot;

    }
}
