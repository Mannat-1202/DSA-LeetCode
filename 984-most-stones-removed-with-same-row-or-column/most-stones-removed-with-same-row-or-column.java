class Solution {
    public int removeStones(int[][] stones) {
        
        int n = stones.length;
        int[] parent = new int[n];
        int component = n;
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    int root1 = find(i,parent);
                    int root2 = find(j,parent);
                    if(root1 != root2){
                    union(i,j,parent);
                    component--;
                    }
                }
            }
        }
        return n - component;
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