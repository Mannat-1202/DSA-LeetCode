class Solution {

    char[][] board;
    String word;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        this.board = board;
        this.word = word;

        int m = board.length;
        int n = board[0].length;

        visited = new boolean[m][n];

        // Try every cell as a starting point
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int index) {

        // Entire word matched
        if (index == word.length()) {
            return true;
        }

        // Out of bounds
        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length) {
            return false;
        }

        // Already visited
        if (visited[i][j]) {
            return false;
        }

        // Character doesn't match
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark current cell
        visited[i][j] = true;

        int[][] directions = {
            {0, 1},   // right
            {0, -1},  // left
            {1, 0},   // down
            {-1, 0}   // up
        };

        // Explore all 4 directions
        for (int[] dir : directions) {

            int ni = i + dir[0];
            int nj = j + dir[1];

            if (dfs(ni, nj, index + 1)) {
                return true;
            }
        }

        // Backtrack
        visited[i][j] = false;

        return false;
    }
}