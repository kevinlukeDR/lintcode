package BinarySearch;

public class Pow {
    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {

//        428. Pow(x, n)
//        Implement pow(x, n).
//
//        Example
//        Pow(2.1, 3) = 9.261
//        Pow(0, 1) = 0
//        Pow(1, 0) = 1
//        Challenge
//        O(logn) time

        // write your code here
        if (n == 0) {
            return 1;
        }
        if (x == 1) {
            return 1;
        }
        boolean isFraction = (n < 0);
        boolean isNegative = (x < 0);
        double res = 1;
        double temp = 1;
        double base = Math.abs((double) x);
        double pow = Math.abs((double) n);
        while (temp <= pow) {
            if (temp + temp > pow) {
                res *= base;
                base = Math.abs((double) x);
                pow -=  temp;
                temp = 1; // TODO: Never forget continue....
                continue;
            }
            temp += temp;
            base *= base;
        }
        //TODO: Could have Fraction or Negative result
        if (isNegative) {
            if (isFraction) {
                return -(1D / res);
            } else {
                return -res;
            }
        } else {
            if (isFraction) {
                return 1D / res;
            } else {
                return res;
            }
        }
    }
}
