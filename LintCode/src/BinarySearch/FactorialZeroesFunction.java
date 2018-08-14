package BinarySearch;

public class FactorialZeroesFunction {
//    1023. Preimage Size of Factorial Zeroes Function
//    Let f(x) be the number of zeroes at the end of x!. (Recall that x! = 1 * 2 * 3 * ... * x, and by convention, 0! = 1.)
//
//    For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) = 2 because 11! = 39916800 has 2 zeroes at the end. Given K, find how many non-negative integers x have the property that f(x) = K.
//
//            Example
//    Example 1:
//
//    Input: K = 0
//    Output: 5
//    Explanation: 0!, 1!, 2!, 3!, and 4! end with K = 0 zeroes.
//            Example 2:
//
//    Input: K = 5
//    Output: 0
//    Explanation: There is no x such that x! ends in K = 5 zeroes.

    /**
     * @param K: an integer
     * @return: how many non-negative integers x have the property that f(x) = K
     */
    public int preimageSizeFZF(int K) {
        // Write your code here
        //TODO: first: find lower bound and higher bound,
        //TODO: second: find statement to justify
        long start = 0L, end = 5L * (K + 1), mid = 0L;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            long count = count(mid);
            if (count == K) {
                return 5;
            } else if (count < K) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (count(start) == K || count(end) == K) {
            return 5;
        } else {
            return 0;
        }
    }
    private int count(long K) {
        int res = 0;
        while (K > 0) {
            res += K / 5;
            K /= 5;
        }
        return res;
    }
}
