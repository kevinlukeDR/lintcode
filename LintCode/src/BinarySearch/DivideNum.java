package BinarySearch;

public class DivideNum {


//    414. Divide Two Integers
//    Divide two integers without using multiplication, division and mod operator.
//
//    If it is overflow, return 2147483647
//
//    Example
//    Given dividend = 100 and divisor = 9, return 11.
    /**
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */

    // TODO: There will be negetive dividend and divisor
    public int divide(int dividend, int divisor) {
        // write your code here
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean flag = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);
        long res = 0L;
        long count = 1L;
        long base = Math.abs( (long) divisor);
        long temp = Math.abs( (long) dividend);
        while (base <= temp) {
            if (base + base > temp) {
                res += count;
                count = 1L;
                temp -= base;
                base = Math.abs( (long) divisor);
                continue;
            }
            base += base;
            count += count;
        }
        if (!flag) {
            res = -res;
            return res < (long) Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) res;
        } else {
            return res > (long) Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
        }
    }
}
