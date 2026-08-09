class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        int[] parent = new int[26];

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Union equivalent characters
        for (int i = 0; i < s1.length(); i++) {

            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            int u = ch1 - 'a';
            int v = ch2 - 'a';

            union(u, v, parent);
        }

        // Build answer
        StringBuilder ans = new StringBuilder();

        for (char ch : baseStr.toCharArray()) {

            int idx = ch - 'a';

            int leader = find(idx, parent);

            ans.append((char) (leader + 'a'));
        }

        return ans.toString();
    }

    public void union(int a, int b, int[] parent) {

        int root1 = find(a, parent);
        int root2 = find(b, parent);

        if (root1 == root2) {
            return;
        }

        // Smaller character becomes the leader
        if (root1 < root2) {
            parent[root2] = root1;
        } else {
            parent[root1] = root2;
        }
    }

    public int find(int node, int[] parent) {

        if (parent[node] == node) {
            return node;
        }

        parent[node] = find(parent[node], parent);

        return parent[node];
    }
}