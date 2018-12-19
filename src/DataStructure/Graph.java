package DataStructure;

import java.util.LinkedList;

// This class represents a directed graph using adjacency list representation
public class Graph {
    private int v;  // Number of vertices
    private LinkedList<Integer> adj[];  // Adjacency lists

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // If is an undirected graph, should add twice
        adj[s].add(t);
    }

    // Prints BFS traversal from a given source s.
    // Time complexity : O(V+E); Space complexity : O(V)
    void BFS(int s) {
        // Mark all the vertices as not visited (By default set as false)
        boolean[] visited = new boolean[v];

        // Create queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            int vertex = queue.poll();
            System.out.print(vertex + " -> ");
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (int i : adj[vertex]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
            /* // We can also use ListIterator to iterate the elements in the Adjacency List
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
             */
        }
    }

    void DFSUtil(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " -> ");

        for (int i : adj[s]) {
            if (!visited[i]) {
                DFSUtil(i, visited);
            }
        }
        /* // We can also use ListIterator to iterate the elements in the Adjacency List
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
         */
    }

    // Prints DFS traversal from a given source s.
    // It uses recursive DFSUtil()
    // Time complexity : O(V+E); Space complexity : O(V)
    void DFS(int s) {
        boolean[] visited = new boolean[v];
        DFSUtil(s, visited);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.addEdge(1, 4);
        graph.addEdge(4, 2);
        graph.addEdge(3, 4);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");
        graph.BFS(2);

        System.out.println("\nFollowing is Depth First Traversal "+
                "(starting from vertex 2)");
        graph.DFS(2);
    }

}
