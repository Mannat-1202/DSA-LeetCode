class Solution {
    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();
        int half = n / 2;

        // Count characters
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // More than one odd frequency => impossible palindrome
        int oddCount = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                oddCount++;
                middle = i;
            }
        }

        if (oddCount > 1) {
            return "";
        }

        // We only need half of each character for the left half
        for (int i = 0; i < 26; i++) {
            freq[i] /= 2;
        }

        char[] ans = new char[n];

        // Try to make left half equal to target's left half
        int pos = 0;

        while (pos < half) {

            int c = target.charAt(pos) - 'a';

            if (freq[c] == 0) {
                break;
            }

            ans[pos] = target.charAt(pos);
            freq[c]--;
            pos++;
        }

        // If we matched the entire left half,
        // check whether the resulting palindrome is > target.
        if (pos == half) {

            buildPalindrome(ans, half, middle);

            String candidate = new String(ans);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * We could not use target's left half directly,
         * or it produced a palindrome <= target.
         *
         * Now backtrack from right to left.
         */
        while (true) {

            if (pos < half) {

                int targetChar = target.charAt(pos) - 'a';

                // Try a character strictly greater than target[pos]
                for (int c = targetChar + 1; c < 26; c++) {

                    if (freq[c] == 0) {
                        continue;
                    }

                    ans[pos] = (char) ('a' + c);
                    freq[c]--;

                    // Fill remaining positions with smallest characters
                    int index = pos + 1;

                    for (int x = 0; x < 26; x++) {
                        for (int count = 0; count < freq[x]; count++) {
                            ans[index++] = (char) ('a' + x);
                        }
                    }

                    buildPalindrome(ans, half, middle);

                    return new String(ans);
                }
            }

            // Cannot increase current position,
            // so go one position back.
            if (pos == 0) {
                return "";
            }

            pos--;

            // Restore the character we matched from target
            int restored = target.charAt(pos) - 'a';
            freq[restored]++;
        }
    }

    private void buildPalindrome(char[] ans, int half, int middle) {

        // Put middle character
        if (middle != -1) {
            ans[half] = (char) ('a' + middle);
        }

        // Mirror left half
        for (int i = 0; i < half; i++) {
            ans[ans.length - 1 - i] = ans[i];
        }
    }
}