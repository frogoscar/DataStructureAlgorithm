package DSAAJ.DisjointSet;

public class DisjSetsSmart {
    private int[] s;

    public DisjSetsSmart(int numElements) {
        s = new int[numElements];
        for (int i = 0; i < s.length; i++) {
            s[i] = -1;
        }
    }

    /**
     * Union two disjoint sets using the height heuristic.
     * For simplicity, we assume root1 and root2 are distinct
     * and represent set names.
     * @param root1 the root of set 1.
     * @param root2 the root of set 2.
     */
    public void union(int root1, int root2) {
        if (s[root2] < s[root1]) { // root2 is deeper
            s[root1] = root2;  // Make root2 the new root
        } else {
            if (s[root1] == s[root2]) {
                s[root1]--;    // Update height if same
            }
            s[root2] = root1;  // Make root1 the new root
        }
    }

    /**
     * Perform a find.
     * Error checks omitted again for simplicity.
     * @param x the element being searched for.
     * @return the set containing x.
     */
    public int find(int x) {
        if (s[x] < 0) {
            return x;
        }
        return s[x] = find(s[x]);
    }

    // All finds on same output line should be identical
    public static void main(String[] args) {
        int NumElements = 128;
        int NumInSameSet = 16;

        DisjSetsSmart ds = new DisjSetsSmart(NumElements);
        int set1, set2;

        for (int k = 1; k < NumInSameSet; k *= 2) {
            for (int j = 0; j + k < NumElements; j += 2 * k) {
                set1 = ds.find(j);
                set2 = ds.find(j + k);
                ds.union(set1, set2);
            }
        }

        for (int i = 0; i < NumElements; i++) {
            System.out.print(ds.find(i) + "*");
            if (i % NumInSameSet == NumInSameSet - 1) {
                System.out.println();
            }
        }
    }
}
