class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        //for pacific ocean
        //top row
        for(int c = 0;c <cols ;c++){
            dfs(0,c,heights,pacific);
        }
        //left column
        for(int r=0;r<rows;r++){
            dfs(r,0,heights,pacific);
        }
        //for atlantic ocean
        //bottom cols
        for(int c=0;c<cols;c++){
            dfs(rows-1,c,heights,atlantic);
        }
        //right row
        for(int r=0;r<rows;r++){
            dfs(r,cols-1,heights,atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    public void dfs(int row ,int col,int[][] heights,boolean[][] visited){
        visited[row][col] = true;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] dir : directions){
            int newrow = row + dir[0];
            int newcol = col +dir[1];
        if(newrow<0 || newrow>=heights.length || newcol<0 || newcol>=heights[0].length){
            continue;
        }
        if(visited[newrow][newcol]){
            continue;
        }
        if(heights[newrow][newcol] < heights[row][col]){
            continue;
        }
         dfs(newrow,newcol,heights,visited);   
        }

    }
}