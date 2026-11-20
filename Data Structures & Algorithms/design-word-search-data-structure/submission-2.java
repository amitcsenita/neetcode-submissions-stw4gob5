class WordDictionary {

   private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();

    }

    public void addWord(String word) {
        TrieNode currentNode = root;
        for (int position = 0 ; position < word.length(); position++) {
            char currentCharacter = word.charAt(position);
            int characterIndex = currentCharacter - 'a';
            if (currentNode.children[characterIndex] == null) {
               currentNode.children[characterIndex]= new TrieNode(); 
            }
            currentNode = currentNode.children[characterIndex];
        }
        currentNode.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchFromNode(root, word, 0);
    }

    public boolean searchFromNode(TrieNode currentNode, String word, int position) {
        if (currentNode == null) {
            return false;
        }
        if (position == word.length()) {
            return currentNode.isEndOfWord;
        }

        char currentCharacter = word.charAt(position);
        if (currentCharacter != '.') {
            TrieNode childNode = currentNode.children[currentCharacter - 'a'];
            if (childNode == null) return false;
            return searchFromNode(childNode, word, position+1);
        } else {
            for (int index = 0; index < 26; index++) {
                TrieNode childNode = currentNode.children[index];
                if (searchFromNode(childNode, word, position+1)) return true;
            }
        }
        return false;
    }
}
