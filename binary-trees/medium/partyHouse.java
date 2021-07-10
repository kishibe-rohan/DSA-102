//Question Link: https://practice.geeksforgeeks.org/problems/party-in-town3951

class Solution {
    static int partyHouse(int N, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] dist = new int[N + 1]; // keep track of dist to farthest node for every node
        Arrays.fill(dist, 0);

        for (int i = 1; i <= N; i++) {
            // keep track of unvisited nodes
            boolean[] vis = new boolean[N + 1];
            Arrays.fill(vis, false);

            dfs(i, adj, 0, vis, dist);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++)
            min = Math.min(min, dist[i]);

        return min;
    }

    static void dfs(int src, ArrayList<ArrayList<Integer>> adj, int dis, boolean[] vis, int[] dist) {
        vis[src] = true;
        for (int nei : adj.get(src)) {
            // calculate dist to unvisited nodes
            if (!vis[nei])
                dfs(nei, adj, dis + 1, vis, dist);
        }

        dist[src] = Math.max(dist[src], dis);
    }
}