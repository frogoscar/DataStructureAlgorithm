package DataStructure.DisjointSet;

// Use Union-Find to check whether a given graph contains cycle or not
public class UnionFind {
    int V;  // Number of vertices
    int E;  // Number of edges
    Edge[] edge;  // Collection of all edges

    class Edge {
        int src;
        int dst;
    }

    // Creates a graph with V vertices and E edges
    UnionFind(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
    }

    // A utility function to find the subset of an element i
    int find(int parent[], int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    // A utility function to do union of two subsets
    void union(int parent[], int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        if (xSet != ySet) {
            parent[xSet] = ySet;
        }
    }

    // The main function to check whether a given graph
    // contains cycle or not
    boolean isCyclic(UnionFind graph) {
        // Allocate memory for creating V subsets
        int[] parent = new int[graph.V];

        // Initialize all subsets as single element sets
        for (int i = 0; i < graph.V; i++) {
            parent[i] = -1;
        }

        // Iterate through all edges of graph, find subset of both
        // vertices of every edge, if both subsets are same, then
        // there is cycle in graph.
        for (int i = 0; i < graph.E; i++) {
            int x = graph.find(parent, graph.edge[i].src);
            int y = graph.find(parent, graph.edge[i].dst);

            if (x == y) {
                return true;
            }

            graph.union(parent, x, y);
        }
        return false;
    }

    public static void main(String[] args) {
        /* Let us create following graph
         0
        |  \
        |    \
        1-----2 */
        int V = 3, E = 3;
        UnionFind graph = new UnionFind(V, E);

        // Add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dst = 1;

        // Add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dst = 2;

        // Add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dst = 2;

        if (graph.isCyclic(graph)) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph does not contain cycle");
        }
    }
}
