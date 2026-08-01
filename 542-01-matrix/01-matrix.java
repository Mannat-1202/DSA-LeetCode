class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int row = mat.length;
        int col = mat[0].length;
        int[][] distance = new int[row][col];

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i=0;i<size;i++){
            int[] current = queue.poll();
            int rows = current[0];
            int cols = current[1];
            for(int [] dir : directions){

                int newrow = rows + dir[0];
                int newcol = cols + dir[1];

                if(newrow<0 || newrow>=distance.length || newcol<0 || newcol>=distance[0].length){
                    continue;
                }
                if(visited[newrow][newcol]){
                    continue;
                }

                visited[newrow][newcol] = true;
                distance[newrow][newcol] = distance[rows][cols] + 1;
                queue.offer(new int[]{newrow,newcol});
            }
            }
        }
        return distance;
    }
}