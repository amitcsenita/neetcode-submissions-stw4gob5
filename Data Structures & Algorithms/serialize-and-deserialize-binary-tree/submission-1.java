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

public class Codec {

    // Encodes a tree to a single string.
    
    public String serialize(TreeNode root) {
        StringBuilder serializedStr = new StringBuilder();
        if (root != null) {
          serializeHelper(root, serializedStr);
        }
       
        return serializedStr.toString();
    }

    void serializeHelper (TreeNode currentNode, StringBuilder serializedStr) {
        if (currentNode == null) {
            serializedStr.append("#,");
            return;
        }
        serializedStr.append(currentNode.val).append(",");
        serializeHelper(currentNode.left, serializedStr);
        serializeHelper(currentNode.right, serializedStr);
    }

    // // Decodes your encoded data to tree.
    // public TreeNode deserialize(String data) {
    //     if (data.length() == 0) return null;
    //     int index = 0;
    //     return deserializeHelper(data, index);
    // }

    // void deserializeHelper(String data, int currentIndex) {
    //     String nextSeparator = data.getNextIndex(","); 
    //     String nextNodeValue = data.substr(currentIndex, nextSeparator - 1);
    //     TreeNode subtreeRoot = new TreeNode();
    //     if (nextNodeValue!= "#") {
    //       treeNode.val = nextNodeValue.toInteger();
    //       treeNode.left = deserializeHelper(data, index + nextSeparator);
    //       treeNode.right =  deserializeHelper(data, index + nextSeparator);
    //     } else {
    //         return null;
    //     }
        
    // }


public TreeNode deserialize(String data) {

    if (data == null || data.isEmpty()) {
        return null;
    }

    // Convert serialized string into individual node tokens.
    String[] serializedTokens = data.split(",");

    // Shared mutable index across recursive calls.
    int[] nextTokenIndex = {0};

    return deserializeSubtree(serializedTokens, nextTokenIndex);
}

/**
 * Consumes the next token and reconstructs its subtree.
 * Returns the root of the reconstructed subtree.
 */
private TreeNode deserializeSubtree(
        String[] serializedTokens,
        int[] nextTokenIndex) {

    // Read exactly one token and advance the shared index.
    String currentToken = serializedTokens[nextTokenIndex[0]++];

    // Missing child: no node to construct.
    if (currentToken.equals("#")) {
        return null;
    }

    // Construct the current subtree root.
    int nodeValue = Integer.parseInt(currentToken);
    TreeNode subtreeRoot = new TreeNode(nodeValue);

    // Reconstruct left subtree completely.
    subtreeRoot.left = deserializeSubtree(
        serializedTokens,
        nextTokenIndex
    );

    // Shared index now points to the right subtree's first token.
    subtreeRoot.right = deserializeSubtree(
        serializedTokens,
        nextTokenIndex
    );

    return subtreeRoot;
}

}
