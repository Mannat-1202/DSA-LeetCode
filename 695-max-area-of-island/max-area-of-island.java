class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        boolean [][] visited = new boolean[rows][cols];
        int maxarea= 0;
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col] == 1 && !visited[row][col]){
                     int area = dfs(row,col,grid,visited);
                     maxarea = Math.max(maxarea,area);
                }
            }
        }
        return maxarea;
    }
    public int dfs(int row,int col,int[][] grid,boolean[][] visited){

        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length){
            return 0;
        }

        if(grid[row][col] == 0){
            return 0;
        }

        if(visited[row][col]){
            return 0;
        }
        visited[row][col] = true;

        int area = 1 + dfs(row-1,col,grid,visited) +dfs(row+1,col,grid,visited)+dfs(row,col-1,grid,visited) +dfs(row,col+1,grid,visited);

        return area;
    }
}