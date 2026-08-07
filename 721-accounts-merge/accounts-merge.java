class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();

        // DSU Parent Array
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Email -> Account Index
        HashMap<String, Integer> emailToAccount = new HashMap<>();

        // Step 1: Build DSU
        for (int i = 0; i < n; i++) {

            for (int j = 1; j < accounts.get(i).size(); j++) {

                String email = accounts.get(i).get(j);

                if (!emailToAccount.containsKey(email)) {
                    emailToAccount.put(email, i);
                } else {
                    union(i, emailToAccount.get(email), parent);
                }
            }
        }

        // Step 2: Leader -> Emails
        HashMap<Integer, TreeSet<String>> merged = new HashMap<>();

        for (Map.Entry<String, Integer> entry : emailToAccount.entrySet()) {

            String email = entry.getKey();
            int account = entry.getValue();

            int leader = find(account, parent);

            if (!merged.containsKey(leader)) {
                merged.put(leader, new TreeSet<>());
            }

            merged.get(leader).add(email);
        }

        // Step 3: Build Final Answer
        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<Integer, TreeSet<String>> entry : merged.entrySet()) {

            int leader = entry.getKey();

            List<String> current = new ArrayList<>();

            // Add Name
            current.add(accounts.get(leader).get(0));

            // Add Sorted Emails
            current.addAll(entry.getValue());

            ans.add(current);
        }

        return ans;
    }

    // DSU Find with Path Compression
    public int find(int node, int[] parent) {

        if (parent[node] == node) {
            return node;
        }

        parent[node] = find(parent[node], parent);
        return parent[node];
    }

    // DSU Union
    public void union(int a, int b, int[] parent) {

        int rootA = find(a, parent);
        int rootB = find(b, parent);

        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
}