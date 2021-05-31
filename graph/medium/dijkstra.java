//Implement Dijkstra's Algorithm 

public class dijkstra {
    static final int V = 10; // number of vertices

    // utility function to find next nearest vertex
    int minDistance(int dist[], Boolean spt[]) {
        int min = Integer.MAX_VALUE;
        int min_idx = -1;

        for (int v = 0; v < V; v++) {

            // not included in shortest path yet and has less distance?
            if (spt[v] == false && dist[v] <= min) {
                min = dist[v];
                min_idx = v;

            }
        }

        return min_idx;
    }

    // utility function to print solution
    void printSolution(int dist[]) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    void dijkstraAlgo(int graph[][], int src) {
        int dist[] = new int[V]; // dist[i] stores shortest distance from src to vertex i
        Boolean spt[] = new Boolean[V]; // spt[i] is true if vertex i is in SPT (shortest path)

        // initialize all distances as INFINITE and spt[] as false

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            spt[i] = false;
        }

        dist[src] = 0; // distance of src to itself is 0

        // Find shortest path for other vertices
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, spt); // get next closest vertex

            spt[u] = true; // add it to spt

            // update dist values for its adjacent vertices
            for (int v = 0; v < V; v++) {
                if (!spt[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }

        }

        printSolution(dist);

    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        t = new dijkstra();
        t.dijkstraAlgo(graph, 0);

    }

}
