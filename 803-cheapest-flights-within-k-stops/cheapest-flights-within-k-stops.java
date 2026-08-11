class Solution {
    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {

            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph.get(from).add(new int[]{to, price});
        }

        // dist[node][flights]
        int[][] dist = new int[n][k + 2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // [cost, node, flightsTaken]
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        dist[src][0] = 0;

        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int cost = current[0];
            int node = current[1];
            int flightsTaken = current[2];

            if (node == dst) {
                return cost;
            }

            // Cannot take more than k + 1 flights
            if (flightsTaken == k + 1) {
                continue;
            }

            for (int[] edge : graph.get(node)) {

                int neighbor = edge[0];
                int price = edge[1];

                int newCost = cost + price;
                int newFlights = flightsTaken + 1;

                if (newCost < dist[neighbor][newFlights]) {

                    dist[neighbor][newFlights] = newCost;

                    pq.offer(new int[]{
                        newCost,
                        neighbor,
                        newFlights
                    });
                }
            }
        }

        return -1;
    }
}