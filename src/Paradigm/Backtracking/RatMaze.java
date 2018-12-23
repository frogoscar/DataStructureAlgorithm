package Paradigm.Backtracking;

public class RatMaze {
    static final int N = 4;

    // A utility function to print solution matrix sol[N][N]
    static void printSolution(int[][] sol) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(" " + sol[x][y] + " ");
            }
            System.out.println();
        }
    }

    // A utility function to check if x,y is valid index for N*N maze
    static boolean isSafe(int[][] maze, int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1;
    }

    static boolean solveMaze(int[][] maze) {
        int[][] sol = new int[N][N];

        if (!solveMazeUtil(maze, 0, 0, sol)) {
            System.out.print("Solution doesn't exist");
            return false;
        }
        printSolution(sol);
        return true;
    }

    // A recursive utility function to solve Maze problem
    static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {
            // Mark x,y as part of solution path
            sol[x][y] = 1;

            // Move forward in x direction
            if (solveMazeUtil(maze, x + 1, y, sol)) {
                return true;
            }

            // If moving in x direction doesn't give
            // solution then  Move down in y direction
            if (solveMazeUtil(maze, x, y + 1, sol)) {
                return true;
            }

            // If none of the above movements works then
            // BACKTRACK: un-mark x,y as part of solution path
            sol[x][y] = 0;  // Backtracking
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        solveMaze(maze);
    }
}
