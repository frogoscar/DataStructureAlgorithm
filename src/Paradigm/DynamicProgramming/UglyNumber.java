package Paradigm.DynamicProgramming;

// Get the nth ugly number
// Ugly numbers are numbers whose only prime
// factors are 2, 3 or 5.
// The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
// shows the first 11 ugly numbers.
// By convention, 1 is included.
public class UglyNumber {
    // This function divides a by greatest divisible
    // power of b
    static int maxDivide(int a, int b) {
        while (a % b == 0) {
            a /= b;
        }
        return a;
    }

    static boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        n = maxDivide(n, 2);
        n = maxDivide(n, 3);
        n = maxDivide(n, 5);

        return n == 1;
    }

    static int getNthUglyNum(int n) {
        int[] dp = new int[n]; // To store ugly numbers
        int i2 = 0, i3 = 0, i5 = 0;
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(nextMultipleOf2,
                    Math.min(nextMultipleOf3, nextMultipleOf5));
            if (dp[i] == nextMultipleOf2) {
                i2++;
                nextMultipleOf2 = dp[i2] * 2;
            }
            if (dp[i] == nextMultipleOf3) {
                i3++;
                nextMultipleOf3 = dp[i3] * 3;
            }
            if (dp[i] == nextMultipleOf5) {
                i5++;
                nextMultipleOf5 = dp[i5] * 5;
            }
        }
        return dp[n - 1];
    }

    public static void main(String args[]) {
        int n = 150;
        System.out.println(getNthUglyNum(n));
    }
}
