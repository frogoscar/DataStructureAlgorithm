package Paradigm.Backtracking;

public class NQueen {
    static final int N = 4;

    // A utility function to print solution matrix sol[N][N]
    static void printSolution(int[][] sol) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(" " + sol[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
    A utility function to check if a queen can
    be placed on board[row][col]. Note that this
    function is called when "col" queens are already
    placed in columns from 0 to (col - 1). So we need
    to check only left side for attacking queens
    */
    static boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        // Check this row on left side
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on left side
        for (i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    //A recursive utility function to solve N Queen problem
    static boolean solveNQUtil(int[][] board, int col) {
        // If all queens are placed then return true
        if (col >= N) {
            printSolution(board);
            return true;
        }

        // Consider this column and try placing this queen in all rows one by one
        boolean res = false;
        for (int i = 0; i < N; i++) {
            // Check if the queen can be placed on board[i][col]
            if (isSafe(board, i, col)) {
                // Place this queen in board[i][col]
                board[i][col] = 1;

                // Make result true if any placement is possible
                res = solveNQUtil(board, col + 1) || res;

                // If placing queen in board[i][col]
                // doesn't lead to a solution then
                // remove queen from board[i][col]
                board[i][col] = 0;  // Backtracking
            }
        }
        // If the queen can not be placed in any row in
        // this column col, then return false
        return res;
    }

    /*
    This function solves the N Queen problem using
    Backtracking.  It mainly uses solveNQUtil () to
    solve the problem. It returns false if queens
    cannot be placed, otherwise, return true and
    prints placement of queens in the form of 1s.
    Please note that there may be more than one
    solutions, this function prints one of the
    feasible solutions.
     */
    static boolean solveNQ() {
        int[][] board = new int[N][N];

        if (!solveNQUtil(board, 0)) {
            System.out.print("Solution doesn't exist");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        solveNQ();
    }
}
