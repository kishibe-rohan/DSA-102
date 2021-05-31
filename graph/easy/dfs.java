//  Implement DFS for a directed graph

public class dfs {
    private int V; // number of vertices
    private LinkedList<Integer> adj[]; // adjacency list representation

    // constructor for graph
    dfs(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void dfsUtil(int v, boolean visited[]) {
        visited[v] = true; // add to visited list
        System.out.print(v + " ");

        // Recur for vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                dfsUtil(n, visited);
        }

    }

    void dfSearch() {
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfsUtil(i, visited);
        }

    }

    public static void main(String args[]) {
        dfs g = new dfs(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.dfSearch();

    }

}
