package Paradigm.DivideConquer;

public class SquareRootOfTwo {

    static double f(double x) {
        return Math.pow(x, 2) - 2;
    }

    static double[] find_zero(double a, double b, double error) {
        if (b - a < error) {
            return new double[]{a, b};
        }

        double mid = (a + b) / 2;
        if (f(a) * f(mid) < 0) {
            return find_zero(a, mid, error);
        } else {
            return find_zero(mid, b, error);
        }
    }

    public static void main(String[] args) {
        double[] res = find_zero(0, 2, 0.0001);
        for (double d : res) {
            System.out.print(d + " ");
        }
    }
}
