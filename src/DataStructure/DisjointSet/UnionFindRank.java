package DataStructure.DisjointSet;

// A union by rank and path compression
// based program to detect cycle in a graph
public class UnionFindRank {
    int V;  // Number of vertices
    int E;  // Number of edges
    Edge[] edge;  // Collection of all edges

    // Creates a graph with V vertices and E edges
    UnionFindRank(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
    }

    // class to represent edge
    class Edge {
        int src;
        int dst;
    }

    // class to represent Subset
    class Subset {
        int parent;
        int rank;
    }

    // A utility function to find
    // set of an element i (uses
    // path compression technique)
    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    // A function that does union
    // of two sets of x and y
    // (uses union by rank)
    void union(Subset[] subsets, int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        if (xRoot == yRoot) {
            return;
        }

        if (subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        } else {
            subsets[xRoot].parent = yRoot;
            subsets[yRoot].rank++;
        }
    }

    // The main function to check whether a given graph
    // contains cycle or not
    boolean isCyclic(UnionFindRank graph) {
        int V = graph.V;
        int E = graph.E;

        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        for (int e = 0; e < E; e++) {
            int x = find(subsets, graph.edge[e].src);
            int y = find(subsets, graph.edge[e].dst);

            if (x == y) {
                return true;
            }
            union(subsets, x, y);
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
        UnionFindRank graph = new UnionFindRank(V, E);

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
