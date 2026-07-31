class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: Find all rotten oranges and count fresh oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // No fresh oranges
        if (fresh == 0) {
            return 0;
        }

        int minutes = 0;

        // Directions: Down, Up, Right, Left
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int[] dir : directions) {

                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow < 0 || newRow >= grid.length ||
                        newCol < 0 || newCol >= grid[0].length) {
                        continue;
                    }

                    if (grid[newRow][newCol] != 1) {
                        continue;
                    }

                    grid[newRow][newCol] = 2;
                    fresh--;

                    queue.offer(new int[]{newRow, newCol});
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes - 1 : -1;
    }
}