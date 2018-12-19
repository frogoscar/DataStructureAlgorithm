package DSAAJ.Graph;

public class Kruskal {
    /* // Kruskal's Algorithm is for solving Minimum Spanning Tree (another Algorithm is Prim's Algo)
    ArrayList<Edge> kruskal(List<Edge> edges, int numVertices) {
        DisjSets ds = new DisjSets(numVertices);
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges);
        List<Edge> mst = new ArrayList<>();
        while (mst.size() != numVertices - 1) {
            Edge e = pq.deleteMin();     // Edge e = (u, v)
            SetType uset = ds.find(e.getu());
            SetType vset = ds.find(e.getv());
            if (uset != vset) {
                // Accept the edge
                mst.add(e);
                ds.union(uset, vset);
            }
        }
        return mst;
    }
    */  // Pseudo code
}
