import java.util.*;

//Given a graph
//check if the graph is a tree or not
//For graph to be tree ,it must be 1)connected and 2)there must be no cycle

public class isTree {
    public static boolean isGraphTree(int V, LinkedList<Integer> adj[]) {
        // adj[i] contains the list of adjacent vertices for vertex i
        // V is the number of vertices
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++)
            visited[i] = false;

        // check if there is a cycle
        if (isCyclic(0, visited, -1, adj))
            return false;

        // check if it is connected i.e. every vertex can be reached from src
        for (int i = 0; i < V; i++)
            if (!visited[i])
                return false;

        return true;
    }

    private static boolean isCyclic(int current, boolean[] visited, int parent, LinkedList<Integer> adj[]) {
        // mark current node as visited
        visited[current] = true;
        Integer connected;

        // check for every adjacent vertex of current vertex
        Iterator<Integer> it = adj[current].iterator();
        while (it.hasNext()) {
            connected = it.next(); // get adjacent vertex

            // not visited?visit
            if (!visited[connected])
                isCyclic(connected, visited, current, adj);

            // already visited?must be parent of current node
            else if (connected != parent)
                return true;
        }

        return false;
    }
}
