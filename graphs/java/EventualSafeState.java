import java.util.*;

public class EventualSafeState {
    public static void main(String[] args) {
        int[][] adj = {
            {0, 1, 0, 0, 0}, // Example adjacency matrix
            {0, 0, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0}
        };
        int V = adj.length;
        List<Integer> safeNodes = find(V, adj);
        System.out.println("Safe nodes: " + safeNodes);
    }

    public static List<Integer> find(int V, int[][] adj) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];       // Tracks visited nodes
        boolean[] markPath = new boolean[V];      // Tracks nodes in the current DFS path (to detect cycles)
        boolean[] safe = new boolean[V];          // Tracks eventually safe nodes

        // Perform DFS on each node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(visited, markPath, safe, adj, i);
            }
        }

        // Collect all nodes marked as safe
        for (int i = 0; i < V; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static boolean dfs(boolean[] visited, boolean[] markPath, boolean[] safe, int[][] adj, int node) {
        visited[node] = true;
        markPath[node] = true;

        for (int i = 0; i < adj[node].length; i++) {
            if (adj[node][i] == 1) { // If there's an edge to node i
                if (!visited[i]) {
                    // If DFS finds a cycle, return true
                    if (dfs(visited, markPath, safe, adj, i)) {
                        return true;
                    }
                } else if (markPath[i]) {
                    // If we encounter a node in the current path, it's a cycle
                    return true;
                }
            }
        }

        // If no cycle found, mark the node as safe
        markPath[node] = false;
        safe[node] = true;
        return false;
    }
}

