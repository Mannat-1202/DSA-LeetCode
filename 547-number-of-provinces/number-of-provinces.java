class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        int[] parent = new int[n+1];
        int count = 0;
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        int component = n;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j] == 1){
                    int rootu = find(i,parent);
                    int rootv = find(j,parent);

                    if(rootu != rootv){
                        union(i,j,parent);
                        component--;
                    }
                }
            }
        }
        return component;
    }
    public int find(int node, int[] parent){
        if(parent[node] == node){
            return node;
        }
        parent[node] = find(parent[node],parent);
        return parent[node];
    }
    public void union(int a,int b,int[] parent){
        int root1 = find(a,parent);
        int root2 = find(b,parent);

        if(root1 != root2){
            parent[root1] = root2;
        }
        
    }
}