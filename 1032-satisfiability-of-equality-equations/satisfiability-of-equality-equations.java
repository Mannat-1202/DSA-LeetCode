class Solution {
    public boolean equationsPossible(String[] equations) {
        
        int[] parent = new int[26];
        for(int i=0;i<26;i++){
            parent[i] = i;
        }
        //pass 1
        for(String eq : equations){
            
            if(eq.charAt(1) == '='){
                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';

                union(u,v,parent);
            } 
        }
        // pass 2
        for(String eqs : equations){

            if(eqs.charAt(1) == '!'){

                int u = eqs.charAt(0) - 'a';
                int v = eqs.charAt(3) - 'a';

                int root1 = find(u,parent);
                int root2 = find(v,parent);
                if(root1 == root2){
                    return false;
                }
            }
        }
        return true;
    }
    public int find(int node,int[] parent){
        if(parent[node] == node){
            return node;
        }
        parent[node] = find(parent[node],parent);
        return parent[node];
    }
    public void union(int a ,int b, int[] parent){
        int root1 = find(a,parent);
        int root2 = find(b,parent);
        if(root1 != root2){
            parent[root1] = root2;
        }
    }
}