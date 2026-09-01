class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int[][] litter = new int[m][n];

        int startX = 0;
        int startY = 0;
        int litterCount = 0;

        // Find start and assign an index to every litter cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char c = classroom[i].charAt(j);

                if (c == 'S') {
                    startX = i;
                    startY = j;
                } 
                else if (c == 'L') {
                    litter[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        // No litter
        if (litterCount == 0) {
            return 0;
        }

        int allCollected = (1 << litterCount) - 1;

        /*
         * visited[row][col][energy][mask]
         */
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        Queue<int[]> queue = new LinkedList<>();

        // row, col, remainingEnergy, mask
        queue.offer(new int[]{
            startX,
            startY,
            energy,
            0
        });

        visited[startX][startY][energy][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] current = queue.poll();

                int x = current[0];
                int y = current[1];
                int currentEnergy = current[2];
                int mask = current[3];

                // All litter collected
                if (mask == allCollected) {
                    return moves;
                }

                // No energy means we cannot move
                if (currentEnergy == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {

                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    // Outside grid
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[nx].charAt(ny) == 'X') {
                        continue;
                    }

                    int newEnergy = currentEnergy - 1;
                    int newMask = mask;

                    char cell = classroom[nx].charAt(ny);

                    // Reset energy
                    if (cell == 'R') {
                        newEnergy = energy;
                    }

                    // Collect litter
                    if (cell == 'L') {
                        newMask |= (1 << litter[nx][ny]);
                    }

                    if (!visited[nx][ny][newEnergy][newMask]) {

                        visited[nx][ny][newEnergy][newMask] = true;

                        queue.offer(new int[]{
                            nx,
                            ny,
                            newEnergy,
                            newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}