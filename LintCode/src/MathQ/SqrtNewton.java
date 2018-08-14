package MathQ;

public class SqrtNewton {
    public static double sqrt(int c) {
        if (c < 0) {
            return Double.NaN;
        }
        double EPSILON = 1E-15;
        double res = (double) c, last = (double) c;
        while (Math.abs(res - last / res) > EPSILON) {
            res = (last / res + res) / 2.0;
        }
        return res;
    }
}
