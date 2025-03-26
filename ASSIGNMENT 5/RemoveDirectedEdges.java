import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static List<Integer>[] reverseGraph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of nodes
        int m = sc.nextInt(); // Number of edges

        // Initialize the graph and reverse graph
        graph = new ArrayList[n];
        reverseGraph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        List<int[]> edges = new ArrayList<>();

        // Reading the edges
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            graph[u].add(v);
            reverseGraph[v].add(u);
            edges.add(new int[]{u, v});
        }

        // Step 1: Perform DFS from any node to find the connected components
        visited = new boolean[n];
        dfs(0);

        // Step 2: Reverse DFS to check the reachability in the reverse direction
        boolean[] reachable = new boolean[n];
        reverseDfs(0, reachable);

        // Step 3: Find all the edges that can be removed
        List<int[]> removableEdges = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            // If both u and v are reachable and removing this edge doesn't disconnect the graph
            // in either direction, mark it for removal
            if (reachable[u] && !reachable[v]) {
                removableEdges.add(edge);
            }
        }

        // Output the result
        System.out.println(removableEdges.size());
        for (int[] edge : removableEdges) {
            System.out.println((edge[0] + 1) + " " + (edge[1] + 1));
        }

        sc.close();
    }

    // DFS function to mark visited nodes
    private static void dfs(int node) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    // Reverse DFS to check reachable nodes in the reverse direction
    private static void reverseDfs(int node, boolean[] reachable) {
        reachable[node] = true;
        for (int neighbor : reverseGraph[node]) {
            if (!reachable[neighbor]) {
                reverseDfs(neighbor, reachable);
            }
        }
    }
}
