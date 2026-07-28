class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean[] visited = new boolean[rooms.size()];
         dfs( 0,rooms,visited);

        for(boolean room : visited){
            if(!room) return false;
        }

        return true;
    }
    public void  dfs(int node ,List<List<Integer>> rooms,boolean[] visited ){

        visited[node] = true;

        for(int nextroom : rooms.get(node)){

            if(!visited[nextroom]){
                dfs(nextroom,rooms,visited);
            }
        }
        
    }
}