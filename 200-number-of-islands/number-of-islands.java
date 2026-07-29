class Solution {

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int count = 0;

        // Traverse every cell in the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // If it is land and not visited, we found a new island
                if (grid[row][col] == '1' && !visited[row][col]) {
                    dfs(row, col, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int row, int col, char[][] grid, boolean[][] visited) {

        // 1. Outside the grid
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length) {
            return;
        }

        // 2. Water
        if (grid[row][col] == '0') {
            return;
        }

        // 3. Already visited
        if (visited[row][col]) {
            return;
        }

        // Mark current cell as visited
        visited[row][col] = true;

        // Visit all four directions
        dfs(row - 1, col, grid, visited); // Up
        dfs(row + 1, col, grid, visited); // Down
        dfs(row, col - 1, grid, visited); // Left
        dfs(row, col + 1, grid, visited); // Right
    }
}