class Solution {
    private static class TrieNode {
       TrieNode[] children = new TrieNode[26];
       boolean isEndOfWord = false;
    }

    private TrieNode rootTrieNode;
    private Set<String> foundWords;
    private Set<Integer> visitedCells;
    private StringBuilder currentWord;

    private void insertIntoTrie(String word) {
        TrieNode currentTrieNode = rootTrieNode;

        for (int position = 0; position < word.length(); position++) {
           char currentCharacter = word.charAt(position);
           int currentCharcterIndex = currentCharacter - 'a';
           if (currentTrieNode.children[currentCharcterIndex] == null) {
             currentTrieNode.children[currentCharcterIndex] = new TrieNode();
           }
           currentTrieNode = currentTrieNode.children[currentCharcterIndex];
        }
        currentTrieNode.isEndOfWord = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        rootTrieNode = new TrieNode();
        foundWords = new HashSet<>();
        visitedCells = new HashSet<>();
        currentWord = new StringBuilder();

        for (String word: words) {
          insertIntoTrie(word);
        }

        int rows = board.length;
        int cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
              startDFS(row, col, rootTrieNode, board);
            }
        }
        
        return new ArrayList<>(foundWords);
    }

    void startDFS(int row, int col, TrieNode currentTrieNode, char[][] board) {
        int rowCount =  board.length;
        int colCount =  board[0].length;
        if (row < 0 || row >=rowCount  || col < 0 || col >= colCount) {
            return ;
        }

        int cellId = row * colCount + col;
        if (visitedCells.contains(cellId)) {
            return;
        }
        
        char currentCharacter = board[row][col];
        int characterIndex = currentCharacter - 'a';
        
        TrieNode matchingChildNode = currentTrieNode.children[characterIndex];
        if (matchingChildNode == null) {
            return ;
        }

        visitedCells.add(cellId);
        currentWord.append(currentCharacter);

        if (matchingChildNode.isEndOfWord) {
           foundWords.add(currentWord.toString());
        }

        startDFS(row+1, col, matchingChildNode, board);
        startDFS(row-1, col, matchingChildNode, board);
        startDFS(row, col+1, matchingChildNode, board);
        startDFS(row, col-1, matchingChildNode, board);

        visitedCells.remove(cellId);
        currentWord.deleteCharAt(currentWord.length() - 1);
    }



}
