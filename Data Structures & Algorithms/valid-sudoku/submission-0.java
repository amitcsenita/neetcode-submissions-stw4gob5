class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer>[] rowsSet = new HashSet[9];
        HashSet<Integer>[] colsSet = new HashSet[9];

        HashSet<Integer>[][] boxsSet = new HashSet[3][3];

        for (int i = 0; i < 9 ; i++) {
           rowsSet[i] = new HashSet<>();
           colsSet[i] = new HashSet<>(); 
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boxsSet[i][j] = new HashSet<>();
            }
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char cellValue = board[row][col];
                if(cellValue == '.') continue;
                int cellNumVal  = Integer.parseInt(String.valueOf(cellValue));
                if (rowsSet[row].contains(cellNumVal)) return false;
                if (colsSet[col].contains(cellNumVal)) return false;
                if (boxsSet[row/3][col/3].contains(cellNumVal)) return false;
                rowsSet[row].add(cellNumVal);
                colsSet[col].add(cellNumVal);
                boxsSet[row/3][col/3].add(cellNumVal);
            }
        }
        return true;
    }
}
