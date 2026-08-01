class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        if(n==1 ) return 1;


        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};

        while(!queue.isEmpty()){
            int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                int path = current[2];

            for(int[] dir : directions){
                int newrow = row + dir[0];
                int newcol = col + dir[1];
                
                if(newrow<0 || newrow>=grid.length || newcol<0 || newcol>=grid[0].length){
                    continue;
                }
                if(visited[newrow][newcol]){
                    continue;
                }
                if(grid[newrow][newcol] == 1){
                    continue;
                }    
                if(newrow == n-1 && newcol == n-1){
                    return path+1;
                }
                visited[newrow][newcol] = true;
                queue.offer(new int[]{newrow,newcol,path+1});   

            }
        }

        return -1;

    }
}