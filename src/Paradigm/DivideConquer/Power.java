package Paradigm.DivideConquer;

public class Power {
    static double pow(double x, int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1 / x;
        } else if (n % 2 == 0) {
            double a = pow(x, n / 2);
            return a * a;
        } else {
            double a = pow(x, n / 2);
            return x * a * a;
        }
    }

    public static void main(String[] args) {
        System.out.println("64 to the power of 15 is " + pow(64, 15));
    }
}
