package Algorithm.Graph;

// Java program to count islands in boolean 2D matrix using DFS
// An island is surrounded by water and is formed by connecting
// adjacent lands horizontally or vertically.
public class NumberIslandDFS {
    static final int ROW = 5;
    static final int COL = 5;

    // A function to check if a given cell (row, col) can
    // be included in DFS
    static boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return row >= 0 && row < ROW && col >= 0 && col < COL
                && M[row][col] == 1 && !visited[row][col];
    }

    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    static void DFS(int M[][], int row, int col, boolean visited[][]) {
        // These arrays are used to get row and column numbers
        // of 4 neighbors of a given cell
        int[] rowNbr = {-1, 0, 0, 1};
        int[] colNbr = {0, -1, 1, 0};

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int i = 0; i < 4; i++) {
            if (isSafe(M, row + rowNbr[i], col + colNbr[i],
                    visited)) {
                DFS(M, row + rowNbr[i], col + colNbr[i],
                        visited);
            }
        }
    }

    // The main function that returns count of islands in a given
    //  boolean 2D matrix
    static int countIslands(int M[][]) {
        boolean[][] visited = new boolean[ROW][COL];

        // Initialize count as 0 and traverse through all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    // If a cell with value 1 is not visited yet,
                    // then new island found. Visit all cells
                    // in this island and increment island count
                    DFS(M, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int M[][] = new int[][]{{1, 1, 0, 0, 0},
                                {0, 1, 0, 0, 1},
                                {1, 0, 0, 1, 1},
                                {0, 0, 0, 0, 0},
                                {1, 0, 1, 0, 1}};
        System.out.println("Number of islands is: "+ countIslands(M));
    }
}
