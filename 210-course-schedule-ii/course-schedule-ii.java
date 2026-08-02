class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      //Kahn's algorithm
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int index = 0;
        int completed = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            completed++;
            order[index] = course;
            index++;
            for(int next : graph.get(course)){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
           
        }
        if(completed == numCourses){
            return order;
        }

        return new int[0];   
    }
}