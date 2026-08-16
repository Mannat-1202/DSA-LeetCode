class Solution {
    public boolean stoneGameIX(int[] stones) {

        int[] count = new int[3];

        for (int stone : stones) {
            count[stone % 3]++;
        }

        // If there are no stones with remainder 1 or 2,
        // Alice cannot make the sum non-divisible by 3.
        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        }

        return Math.abs(count[1] - count[2]) > 2;
    }
}