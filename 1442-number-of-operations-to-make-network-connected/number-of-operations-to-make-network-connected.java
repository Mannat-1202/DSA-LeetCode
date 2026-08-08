class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        int extraedges = 0;
        int component = n;
        int [] parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        for(int[] connection : connections){
            int u = connection[0];
            int v = connection[1];
            int rootu = find(u,parent);
            int rootv = find(v,parent);
            if(rootu == rootv){
                extraedges++;
            }
            else{
                parent[rootu] = rootv;
                component--;
            }
        }
        if(extraedges >= component -1){
            return component -1;
        }
        return -1;
    }
    public int find(int node,int[] parent){
        if(parent[node] == node){
            return node;
        }
        parent[node] = find(parent[node],parent);
        return parent[node];
    }
}