class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // we storing {distance , x,y};
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b) -> b[0]-a[0]);

        for(int[] point : points){

            int x = point[0];
            int y = point[1];

            int dist = x*x + y*y;
            maxheap.add(new int[]{dist,x,y});
            if(maxheap.size()>k){
                maxheap.poll();
            }
        }
        int [][] ans = new int[k][2];
        int i=0;
        while(!maxheap.isEmpty()){
            int [] pair = maxheap.poll();

            ans[i][0]= pair[1];
            ans[i][1]= pair[2];
            i++;
        }
        return ans;
    }

}