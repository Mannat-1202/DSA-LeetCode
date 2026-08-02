class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] color = new int[n];
        for(int i=0;i<n;i++){
            if(color[i] == 0){
                color[i] = 1;
                if(!dfs(i,graph,color)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int node,int[][] graph,int[] color){

        for(int neighbor : graph[node]){

            if(color[neighbor] == 0){
                color[neighbor] = -color[node];
                if(!dfs(neighbor,graph,color)){
                    return false;
                }
            }
            else if(color[neighbor] == color[node]){
                return false;
            }
        }
        return true;
    }
}