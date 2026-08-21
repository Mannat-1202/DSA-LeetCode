class Solution {
    public String removeDuplicateLetters(String s) {

        // Count frequency of every character
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Stack to build the answer
        Deque<Character> stack = new ArrayDeque<>();

        // Track characters currently in the stack
        boolean[] used = new boolean[26];

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // This occurrence has now been processed
            count[c - 'a']--;

            // Already present in answer
            if (used[c - 'a']) {
                continue;
            }

            // Greedily remove larger characters
            // if they appear again later
            while (!stack.isEmpty()
                    && c < stack.peek()
                    && count[stack.peek() - 'a'] > 0) {

                char removed = stack.pop();
                used[removed - 'a'] = false;
            }

            // Add current character
            stack.push(c);
            used[c - 'a'] = true;
        }

        // Build answer in reverse
        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}