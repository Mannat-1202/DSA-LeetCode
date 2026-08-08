class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        int[] parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int rootu = find(u,parent);
            int rootv = find(v,parent);
            if(rootu == rootv){
                return edge;
            }
            parent[rootu] = rootv;
        }
        return new int[0];
    }
    public int find(int node,int[] parent){
        if(parent[node] == node){
            return node;
        }
        parent[node] = find(parent[node],parent);
        return parent[node];
    }


}