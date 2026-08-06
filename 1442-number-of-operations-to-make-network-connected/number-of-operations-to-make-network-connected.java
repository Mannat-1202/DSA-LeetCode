class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        if(connections.length<n-1){
            return -1;
        }

        int component = n;
        int extraedges = 0;
        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        for(int[] connection : connections){
            int u = connection[0];
            int v = connection[1];

            int root1 = find(u,parent);
            int root2 = find(v,parent);

            if(root1 == root2){
                extraedges++;
            }else{
            parent[root1] = root2;
            component--;
            }
        }
        if(extraedges>=component-1){
            return component - 1;
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