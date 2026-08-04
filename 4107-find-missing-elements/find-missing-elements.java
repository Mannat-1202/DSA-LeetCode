class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        Arrays.sort(nums);
        
        
        int min = nums[0];
        int max = nums[nums.length-1];

        List<Integer> ans = new ArrayList<>();
        
        int index = 0;
        for(int i=min ;i<max;i++){
          if(index < nums.length && i == nums[index]){
              index++; 
          }
          else{
            ans.add(i);
          }
        }
        return ans;
    }
}