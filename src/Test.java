import java.util.*;

public class Test {

    static long gcd(long m, long n) {
        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    public static void main(String[] args) {
        long m = 60;
        long n = 40;
        System.out.println("GCD of " + m + " and " + n + " is " + gcd(m, n));
    }
}
