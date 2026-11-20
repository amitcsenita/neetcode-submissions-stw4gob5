class PrefixTree {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private final TrieNode root;

    public PrefixTree() {
        root  = new TrieNode();
    }

    public void insert(String word) {
       TrieNode currentNode = root; 
       for (int position = 0; position < word.length(); position++) {
          Character currentCharacter = word.charAt(position);
          int characterIndex = currentCharacter - 'a';
          if (currentNode.children[characterIndex] == null) {
            currentNode.children[characterIndex] = new TrieNode();
          }
          currentNode = currentNode.children[characterIndex];
       }
       currentNode.isEndOfWord = true;
    }

    public boolean search(String word) {
       TrieNode currentNode = root; 
       for (int position = 0; position < word.length(); position++) {
          Character currentCharacter = word.charAt(position);
          int characterIndex = currentCharacter - 'a';
          if (currentNode.children[characterIndex] == null) {
            return false;
          }
          currentNode = currentNode.children[characterIndex];
       }
       return currentNode.isEndOfWord == true;

    }

    public boolean startsWith(String prefix) {
         TrieNode currentNode = root; 
       for (int position = 0; position < prefix.length(); position++) {
          Character currentCharacter = prefix.charAt(position);
          int characterIndex = currentCharacter - 'a';
          if (currentNode.children[characterIndex] == null) {
            return false;
          }
          currentNode = currentNode.children[characterIndex];
       }
       return true; 

    }
}
