package Paradigm.Backtracking;

public class KnightTour {
    static int N = 8;

    // A utility function to check if i,j are valid indexes for N*N chessboard
    static boolean isSafe(int x, int y, int[][] sol) {
        return x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1;
    }

    // A utility function to print solution matrix sol[N][N]
    static void printSolution(int[][] sol) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(" " + sol[x][y] + " ");
            }
            System.out.println();
        }
    }

    // This function solves the Knight Tour problem
    // using Backtracking. This function mainly
    // uses solveKTUtil() to solve the problem. It
    // returns false if no complete tour is possible,
    // otherwise return true and prints the tour.
    // Please note that there may be more than one
    // solutions, this function prints one of the
    // feasible solutions.
    static boolean solveKT() {
        int[][] sol = new int[N][N];

        // Initialization of solution matrix
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                sol[x][y] = -1;
            }
        }

        // xMove[] and yMove[] define next move of Knight.
        // xMove[] is for next value of x coordinate
        // yMove[] is for next value of y coordinate
        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

        // Since the Knight is initially at the first block
        sol[0][0] = 0;

        // Start from 0,0 and explore all tours using solveKTUtil()
        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        }
        printSolution(sol);
        return true;
    }

    // A recursive utility function to solve Knight Tour problem
    static boolean solveKTUtil(int x, int y, int moves, int[][] sol, int[] xMove, int[] yMove) {
        int nextX, nextY;
        if (moves == N * N) {
            return true;
        }
        // Try all next moves from the current coordinate x, y
        for (int i = 0; i < N; i++) {
            nextX = x + xMove[i];
            nextY = y + yMove[i];

            if (isSafe(nextX, nextY, sol)) {
                sol[nextX][nextY] = moves;
                if (solveKTUtil(nextX, nextY, moves + 1, sol, xMove, yMove)) {
                    return true;
                } else {
                    sol[nextX][nextY] = -1;  // Backtracking
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        solveKT();
    }
}
