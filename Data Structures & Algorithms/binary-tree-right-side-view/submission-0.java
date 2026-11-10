
class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideValues = new ArrayList<>();

        traverseRightFirst(root, 0, rightSideValues);

        System.out.println("FINAL: " + rightSideValues);
        return rightSideValues;
    }

    private void traverseRightFirst(
            TreeNode currentNode,
            int currentDepth,
            List<Integer> rightSideValues) {

        if (currentNode == null) return;

        String indent = "  ".repeat(currentDepth);

        System.out.printf(
            "%sENTER node=%d depth=%d shared=%s%n",
            indent, currentNode.val, currentDepth, rightSideValues
        );

        if (currentDepth == rightSideValues.size()) {
            rightSideValues.add(currentNode.val);
            System.out.println(
                indent + "  ADD " + currentNode.val
                + " -> " + rightSideValues
            );
        } else {
            System.out.println(
                indent + "  SKIP " + currentNode.val
                + " (depth already recorded)"
            );
        }

        // Complete the right recursive call first
        if (currentNode.right != null) {
            System.out.println(
                indent + "  CALL right -> " + currentNode.right.val
            );

            traverseRightFirst(
                currentNode.right, currentDepth + 1, rightSideValues
            );

            System.out.println(
                indent + "  BACK from right -> " + currentNode.right.val
            );
        }

        // Only after right returns, start left
        if (currentNode.left != null) {
            System.out.println(
                indent + "  CALL left -> " + currentNode.left.val
            );

            traverseRightFirst(
                currentNode.left, currentDepth + 1, rightSideValues
            );

            System.out.println(
                indent + "  BACK from left -> " + currentNode.left.val
            );
        }

        System.out.println(
            indent + "EXIT node=" + currentNode.val
            + " shared=" + rightSideValues
        );
    }
}
