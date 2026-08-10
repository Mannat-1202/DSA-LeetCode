class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] time : times){

            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph.get(u).add(new int[]{v,w});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int node = current[0];
            int distance = current[1];

            for(int[] edge : graph.get(node)){

                int neighbor = edge[0];
                int weight = edge[1];

                int newDist = distance + weight;
                if(newDist < dist[neighbor]){
                    dist[neighbor] = newDist;
                    pq.offer(new int[]{neighbor,newDist});
                }
                
            }
        }
        int ans = 0;
        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans,dist[i]);
        }
        return ans;
    }
}