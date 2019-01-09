package Paradigm.DynamicProgramming;

// The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path problem.
// The problem is to find shortest distances between every pair of vertices in a
// given edge weighted directed Graph
// Input:
//       graph[][] = { {0,   5,  INF, 10},
//                    {INF,  0,  3,  INF},
//                    {INF, INF, 0,   1},
//                    {INF, INF, INF, 0} }
// which represents the following graph
//             10
//       (0)------->(3)
//        |         /|\
//      5 |          |
//        |          | 1
//       \|/         |
//       (1)------->(2)
//            3
// Note that the value of graph[i][j] is 0 if i is equal to j
// And graph[i][j] is INF (infinite) if there is no edge from vertex i to j.
//
// Output:
// Shortest distance matrix
//      0      5      8      9
//    INF      0      3      4
//    INF    INF      0      1
//    INF    INF    INF      0
public class FloydWarshall {


    public static void main(String[] args) {

    }
}
