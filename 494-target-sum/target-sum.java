class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int sumofarr = 0;

        for (int x : nums) 
            sumofarr += x;

        if (Math.abs(target) > sumofarr)
                return 0;

        if ((sumofarr + target) % 2 != 0)
            return 0;

        int sum = (sumofarr + target) / 2;

        int[][] dp = new int[n + 1][sum + 1];

        // Base Cases
        for (int i = 0; i <= n; i++) {
            dp[0][0] = 1;
        }

        // Fill DP Table
        for (int i = 1; i <= n; i++) {

            for (int j = 0; j <= sum; j++) {

                if (nums[i - 1] <= j) {

                    dp[i][j] = dp[i - 1][j]
                             + dp[i - 1][j - nums[i - 1]];

                } else {

                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
        
    }
}