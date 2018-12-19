package DSAAJ.Hashing;

import java.util.LinkedList;
import java.util.List;

public class SeparateChainingHashTable<T> {
    private static final int DEFAULT_TABLE_SIZE = 101;

    private List<T>[] theLists;
    private int currentSize;

    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChainingHashTable(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
    }

    public void insert(T x) {
        List<T> whichList = theLists[myhash(x)];
        if (!whichList.contains(x)) {
            whichList.add(x);
            // Rehash
            if (++currentSize > theLists.length) {
                rehash();
            }
        }
    }

    public void remove(T x) {
        List<T> whichList = theLists[myhash(x)];
        if (whichList.contains(x)) {
            whichList.remove(x);
            currentSize--;
        }
    }

    public void makeEmpty() {
        for (int i = 0; i < theLists.length; i++) {
            theLists[i].clear();
        }
        currentSize = 0;
    }

    public boolean contains(T x) {
        List<T> whichList = theLists[myhash(x)];
        return whichList.contains(x);
    }

    private void rehash() {
        List<T>[] oldList = theLists;

        // Create new double-sized, empty table
        theLists = new List[nextPrime(2 * theLists.length)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
        // Copy table over
        currentSize = 0;
        for (int j = 0; j < oldList.length; j++) {
            for (T x : oldList[j]) {
                insert(x);
            }
        }
    }

    private int myhash(T x) {
        int hashValue = x.hashCode();
        hashValue %= theLists.length;
        if (hashValue < 0) {
            hashValue += theLists.length;
        }
        return hashValue;
    }

    private static int nextPrime(int n) {
        if (n % 2 == 0) {
            n++;
        }
        while (!isPrime(n)) {
            n += 2;
        }
        return n;
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main( String[] args ) {
        SeparateChainingHashTable<Integer> H = new SeparateChainingHashTable<>();

        long startTime = System.currentTimeMillis( );

        final int NUMS = 2000000;
        final int GAP = 37;

        System.out.println( "Checking... (no more output means success)" );

        for (int i = GAP; i != 0; i = (i + GAP) % NUMS) {
            H.insert(i);
        }

        for (int i = 1; i < NUMS; i+= 2) {
            H.remove(i);
        }

        for (int i = 2; i < NUMS; i+=2) {
            if (!H.contains(i)) {
                System.out.println("Find fails " + i);
            }
        }


        for (int i = 1; i < NUMS; i+=2) {
            if (H.contains(i)) {
                System.out.println("OOPS!!! " + i);
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Elapsed time: " + (endTime - startTime));
    }
}
