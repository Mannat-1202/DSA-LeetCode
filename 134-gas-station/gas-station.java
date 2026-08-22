class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int start =0;
        int totalgas = 0;
        int currentgas = 0;
        for(int i=0;i<gas.length;i++){

            int difference = gas[i] - cost[i];
            totalgas += difference;
            currentgas += difference;
            if(currentgas < 0){
                start = i+1;
                currentgas = 0;
            }
        }
        if(totalgas<0){
            return -1;
        }
        else{
            return start;
        }
    }
}