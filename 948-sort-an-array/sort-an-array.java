class Solution {
    public int[] sortArray(int[] nums) {
       
       PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

       for(int num : nums){
        maxheap.add(num);
       }
       int i =nums.length -1;
       int [] ans = new int[nums.length];
       while(!maxheap.isEmpty()){
        ans[i--] = maxheap.poll();
       }
       return ans ;
    }
}