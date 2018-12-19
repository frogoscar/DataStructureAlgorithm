package DSAAJ.Graph;

public class TopologicalSort {
    /* // Pseudo code of Topological Sort
    void topSort() throws CycleFoundException {
        Queue<Vertex> q = new Queue<Vertex>();
        int counter = 0;

        for each Vertex v {
            if (v.indegree == 0) {
                q.enqueue(v);
            }
        }

        while (!q.isEmpty()) {
            Vertex v = q.dequeue();
            v.topNum = counter++;   // Assign next number

            for each Vertex w adjacent to v {
                if (--w.indegree == 0) {
                    q.enqueue(w);
                }
            }
        }

        if (counter != NUM_VERTICES) {
            throw new CycleFoundException;
        }
    }
    */
}
