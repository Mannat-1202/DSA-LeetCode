class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        solve(nums, current, used, ans);

        return ans;
    }

    public void solve(int[] nums, List<Integer> current,
                      boolean[] used, List<List<Integer>> ans) {

        // Base Case
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current)); // Store a copy
            return;
        }

        // Try every number
        for (int i = 0; i < nums.length; i++) {

            // Skip if already used
            if (used[i])
                continue;

            // Choose
            current.add(nums[i]);
            used[i] = true;

            // Explore
            solve(nums, current, used, ans);

            // Undo (Backtrack)
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}