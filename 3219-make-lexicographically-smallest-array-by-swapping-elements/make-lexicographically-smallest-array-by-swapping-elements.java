class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        Integer[] index = new Integer[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        // Sort indices according to nums values
        Arrays.sort(index, (i, j) -> Integer.compare(nums[i], nums[j]));

        int[] answer = new int[n];

        int i = 0;

        while (i < n) {

            int j = i + 1;

            // Find the group
            while (j < n &&
                   nums[index[j]] - nums[index[j - 1]] <= limit) {
                j++;
            }

            // Get original indices of this group
            Integer[] positions = Arrays.copyOfRange(index, i, j);

            // Sort positions so we fill the smallest
            // values into the smallest indices
            Arrays.sort(positions);

            // Assign sorted values to sorted positions
            for (int k = i; k < j; k++) {
                answer[positions[k - i]] = nums[index[k]];
            }

            i = j;
        }

        return answer;
    }
}