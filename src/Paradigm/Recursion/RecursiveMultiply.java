package Paradigm.Recursion;

// Write a recursive function to multiply two integers without
// using the * operator (or / operator). You can use addition,
// subtraction, and bit shifting.
public class RecursiveMultiply {
    // If two integers are both positive
    static int minProductPositive(int a, int b) {
        int bigger = a > b ? a : b;
        int smaller = a < b ? a : b;
        return minProductPositiveHelper(smaller, bigger);
    }
    // Time : O(logS) with S the smaller integer
    // Very efficient
    static int minProductPositiveHelper(int smaller, int bigger) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        }

        int s = smaller >> 1;  // Divide by 2
        int halfProd = minProductPositiveHelper(s, bigger);

        if (smaller % 2 == 0) {
            return halfProd + halfProd;
        } else {
            return halfProd + halfProd + bigger;
        }
    }

    // If two integers may be not both positive
    // This is not efficient
    static int multiply(int x, int y) {
        if (y == 0) {
            return 0;
        }

        if (y > 0) {
            return x + multiply(x, y - 1);
        }

        return -multiply(x, -y);
    }

    public static void main(String[] args) {
        int a = 15, b = 50;
        int x = 5, y = -11;

        System.out.println(a + " * " + b + " = " + minProductPositive(a, b));
        System.out.println(x + " * " + y + " = " + multiply(x, y));
    }
}
