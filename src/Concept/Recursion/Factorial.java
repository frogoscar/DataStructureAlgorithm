package Concept.Recursion;

public class Factorial {

    static int Factorial(int n) {
        System.out.println("I am calculating F(" + n + ")");
        if (n == 0) {
            return 1;
        }
        int F = n * Factorial(n - 1);
        System.out.println("Done ! F(" + n + ") is " + F);
        return F;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Factorial(n));
    }
}
