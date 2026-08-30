class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        // Find minimum and maximum indices
        for (int i = 0; i < n; i++) {

            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // Make minIndex the smaller index
        if (minIndex > maxIndex) {
            int temp = minIndex;
            minIndex = maxIndex;
            maxIndex = temp;
        }

        // 1. Both removed from front
        int fromFront = maxIndex + 1;

        // 2. Both removed from back
        int fromBack = n - minIndex;

        // 3. One from front, one from back
        int fromBoth = (minIndex + 1) + (n - maxIndex);

        return Math.min(fromFront, Math.min(fromBack, fromBoth));
    }
}