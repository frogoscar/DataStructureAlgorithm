package Paradigm.DynamicProgramming;

// Given a cost matrix cost[][] and a position (m, n)
// in cost[][], write a function that returns cost of
// minimum cost path to reach (m, n) from (0, 0).
// Each cell of the matrix represents a cost to traverse
// through that cell. Total cost of a path to reach (m, n)
// is sum of all the costs on that path (including both
// source and destination). You can only traverse down,
// right and diagonally lower cells from a given cell, i.e.,
// from a given cell (i, j), cells (i+1, j), (i, j+1) and
// (i+1, j+1) can be traversed. You may assume that all
// costs are positive integers.
public class MinCostPath {
    // Time  : O(mn)
    // Space : O(mn)
    static int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1],
                            Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3},
                        {4, 8, 2},
                        {1, 5, 3}};
        System.out.println("Min Cos is " + minCost(grid));
    }
}
