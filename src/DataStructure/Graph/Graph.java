package DataStructure.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

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

    public void addEdge(int s, int t) {
        // If is an undirected graph, should add twice
        // adj[t].add(s);
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

    void recursiveDFSUtil(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " -> ");

        for (int i : adj[s]) {
            if (!visited[i]) {
                recursiveDFSUtil(i, visited);
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
    // It uses recursive recursiveDFSUtil()
    // Time complexity : O(V+E); Space complexity : O(V)
    void recursiveDFS(int s) {
        boolean[] visited = new boolean[v];
        recursiveDFSUtil(s, visited);
    }

    // Prints DFS traversal from a given source s iteratively
    void iterativeDFS(int s) {
        boolean[] visited = new boolean[v];

        Stack<Integer> stack = new Stack<>();
        stack.push(s);

        while (!stack.empty()) {
            s = stack.pop();

            if (!visited[s]) {
                visited[s] = true;
                System.out.print(s + " -> ");
            }

            for (int i : adj[s]) {
                if (!visited[i]) {
                    stack.push(i);
                }
            }
        }
    }

    void topologicalSortUtil(int s, boolean[] visited, Stack stack) {
        visited[s] = true;
        for (int i : adj[s]) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        // Push current vertex to stack which stores result
        stack.push(s);
    }

    // The function to do Topological Sort. It uses
    // recursive topologicalSortUtil()
    // Time complexity : O(V+E); Space complexity : O(V)
    void topologicalSort() {
        Stack stack = new Stack();
        boolean[] visited = new boolean[v];
        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " -> ");
        }
    }

    void allTopologicalSortsUtil(boolean[] visited, int[] inDegree, ArrayList<Integer> stack) {
        // To indicate whether all topological are found or not
        boolean flag = false;

        for (int i = 0; i < v; i++) {
            // If inDegree is 0 and not yet visited, then only choose that vertex
            if (!visited[i] && inDegree[i] == 0) {
                // 1. Choose (Backtracking)
                visited[i] = true;
                stack.add(i);
                for (int adjacent : adj[i]) {
                    inDegree[adjacent]--;
                }

                // 2. Explore (Backtracking)
                allTopologicalSortsUtil(visited, inDegree, stack);

                // 3. Un-choose (Backtracking)
                // Resetting visited, res and inDegree for backtracking
                visited[i] = false;
                stack.remove(stack.size() - 1);
                for (int adjacent : adj[i]) {
                    inDegree[adjacent]++;
                }

                flag = true;
            }
        }
        // We reach here if all vertices are visited.
        // So we print the solution here
        if (!flag) {
            stack.forEach(i -> System.out.print(i + " -> "));
            System.out.println();
        }
    }

    // The function does all Topological Sort.
    // It uses recursive allTopologicalSortUtil()
    void allTopologicalSorts() {
        boolean[] visited = new boolean[v];

        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int var : adj[i]) {
                inDegree[var]++;
            }
        }

        ArrayList<Integer> stack = new ArrayList<>();

        allTopologicalSortsUtil(visited, inDegree, stack);
    }

    // Determine if there is a path between vertex s and d using BFS
    boolean isReachable(int s, int d) {
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
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (int i : adj[vertex]) {
                if (i == d) {
                    return true;
                }
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        // If BFS is complete without visited d
        return false;
    }

    // This function is a variation of DFSUtil()
    boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i]) {
            return true;
        }
        if (visited[i]) {
            return false;
        }

        visited[i] = true;
        recStack[i] = true;

        for (int j : adj[i]) {
            if (isCyclicUtil(j, visited, recStack)) {
                return true;
            }
        }

        recStack[i] = false;  // Backtracking ?

        return false;
    }

    // Returns true if the graph contains a cycle, else false.
    // This function is a variation of DFS()
    boolean isCyclic() {
        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (isCyclicUtil(i, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // This graph has cycle, not a DAG
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

        System.out.println("\n\nFollowing is Recursive Depth First Traversal "+
                "(starting from vertex 2)");
        graph.recursiveDFS(2);

        System.out.println("\n\nFollowing is Iterative Depth First Traversal "+
                "(starting from vertex 2)");
        graph.iterativeDFS(2);

        if (graph.isCyclic()) {
            System.out.println("\n\nGraph graph contains cycle");
        } else {
            System.out.println("\n\nGraph graph does not contain cycle");
        }

        // Topological Sort can only be applied to DAG
        Graph dag = new Graph(6);
        dag.addEdge(5, 2);
        dag.addEdge(5, 0);
        dag.addEdge(4, 0);
        dag.addEdge(4, 1);
        dag.addEdge(2, 3);
        dag.addEdge(3, 1);
        System.out.println("\n\nFollowing is a Topological " +
                "sort of the given graph");
        dag.topologicalSort();
        System.out.println("\n\nFollowing is All Topological sorts " +
                "of the given graph");
        dag.allTopologicalSorts();
        int s = 5;
        int d = 1;
        if (dag.isReachable(s, d)) {
            System.out.println("\nThere is a path from " + s +" to " + d);
        } else {
            System.out.println("\nThere is no path from " + s +" to " + d);
        }
        s = 0;
        d = 3;
        if (dag.isReachable(s, d)) {
            System.out.println("\nThere is a path from " + s +" to " + d);
        } else {
            System.out.println("\nThere is no path from " + s +" to " + d);
        }

        if (dag.isCyclic()) {
            System.out.println("\nGraph dag contains cycle");
        } else {
            System.out.println("\nGraph dag does not contain cycle");
        }

    }

}
