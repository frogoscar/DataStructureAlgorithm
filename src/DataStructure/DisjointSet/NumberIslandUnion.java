package DataStructure.DisjointSet;

public class NumberIslandUnion {
    int[] rank;
    int[] root;

    public NumberIslandUnion(int n) {
        rank = new int[n];
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
    }

    int find(int i) {
        if (root[i] != i) {
            return find(root[i]);
        }
        return i;
    }

    void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot) {
            return;
        }

        if (rank[xRoot] < rank[yRoot]) {
            root[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            root[yRoot] = xRoot;
        } else {
            root[xRoot] = yRoot;
            rank[yRoot]++;
        }
    }

    int countIslands(int[][] M) {
        int nr = M.length;
        int nc = M[0].length;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (M[i][j] == 0) {
                    continue;
                }
                // Check all 4 neighbors, do a union
                // with neighbor's set if neighbor is also 1
                if (i - 1 >= 0 && M[i - 1][j] == 1) {
                    union(i * nc + j, (i - 1) * nc + j);
                }
                if (j - 1 >= 0 && M[i][j - 1] == 1) {
                    union(i * nc + j, i * nc + j - 1);
                }
                if (j + 1 < nc && M[i][j + 1] == 1) {
                    union(i * nc + j, i * nc + j + 1);
                }
                if (i + 1 < nr && M[i + 1][j] == 1) {
                    union(i * nc + j, (i + 1) * nc + j);
                }
            }
        }

        int[] freq = new int[nr * nc];
        int count = 0;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (M[i][j] == 1) {
                    int root = find(i * nc + j);

                    if (freq[root] == 0) {
                        count++;
                    }
                    freq[root]++;
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

        NumberIslandUnion union = new NumberIslandUnion(M.length * M[0].length);

        System.out.println("Number of islands is: "+ union.countIslands(M));
    }

}
