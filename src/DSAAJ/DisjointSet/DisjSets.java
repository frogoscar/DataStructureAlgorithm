package DSAAJ.DisjointSet;

public class DisjSets {
    private int[] s;

    public DisjSets(int numElements) {
        s = new int[numElements];
        for (int i = 0; i < s.length; i++) {
            s[i] = -1;
        }
    }

    /**
     * Union two disjoint sets.
     * For simplicity, we assume root1 and root2 are distinct
     * and represent set names.
     * @param root1 the root of set 1.
     * @param root2 the root of set 2.
     */
    public void union(int root1, int root2) {
        s[root2] = root1;
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
        return find(s[x]);
    }

    // All finds on same output line should be identical
    public static void main(String[] args) {
        int NumElements = 128;
        int NumInSameSet = 16;

        DisjSets ds = new DisjSets(NumElements);
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
