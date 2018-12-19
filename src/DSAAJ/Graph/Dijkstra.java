package DSAAJ.Graph;

import java.util.List;

public class Dijkstra {
    class Vertex {
        public List adj;  // Adjacency list
        public boolean known;
        public int dist;
        public Vertex path;
    }

    void printPath(Vertex v) {
        if (v.path != null) {
            printPath(v.path);
            System.out.println(" to ");
        }
        System.out.println(v);
    }

    /* // Pseudo code for Dijkstra’s algorithm (Basic)
    void dijkstra(Vertex s) {
        for each Vertex v {
            v.dist = INFINITY;
            v.known = false;
        }
        s.dist = 0;
        while (there is an unknown distance vertex) {
            Vertex v = smallest unknown distance vertex;
            v.known = true;
            for each Vertex w adjacent to v {
                if (!w.known) {
                    int cvw = cost of edge from v to w;
                    if (v.dist + cvw < w.dist) {
                        // Update w
                        decrease(w.dist to v.dist + cvw);
                        w.path = v;
                    }
                }
            }
        }
    }
    */
}
