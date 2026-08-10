class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        int n = s.length();

        // Step 1: Create parent array
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Step 2: Union all connected indices
        for (List<Integer> pair : pairs) {

            int u = pair.get(0);
            int v = pair.get(1);

            union(u, v, parent);
        }

        // Step 3: Create components
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int root = find(i, parent);

            if (!map.containsKey(root)) {
                map.put(root, new ArrayList<>());
            }

            map.get(root).add(i);
        }

        // Step 4: Build the answer
        char[] result = s.toCharArray();

        for (List<Integer> indices : map.values()) {

            // Get characters belonging to this component
            List<Character> chars = new ArrayList<>();

            for (int index : indices) {
                chars.add(result[index]);
            }

            // Sort characters
            Collections.sort(chars);

            // Put smallest characters at smallest indices
            for (int i = 0; i < indices.size(); i++) {
                result[indices.get(i)] = chars.get(i);
            }
        }

        return new String(result);
    }

    public void union(int a, int b, int[] parent) {

        int root1 = find(a, parent);
        int root2 = find(b, parent);

        if (root1 != root2) {
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