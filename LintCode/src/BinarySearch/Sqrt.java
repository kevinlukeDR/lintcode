package BinarySearch;

public class Sqrt {

//    141. Sqrt(x)
//    Implement int sqrt(int x).
//
//    Compute and return the square root of x.
//
//            Example
//    sqrt(3) = 1
//
//    sqrt(4) = 2
//
//    sqrt(5) = 2
//
//    sqrt(10) = 3
//
//    Challenge
//    O(log(x))

    // Same logic like InfiniteSortedFindTarget

    public int sqrt(int x) {
        // write your code here
        long low = 0;
        long high = 1;
        long res = 1;
        while (res < x) {
            low = high;
            high *= 2;
            res = high * high;
        }
        return (int) binarySearch(x, low, high);
    }
    private long binarySearch(int x, long low, long high) {
        long mid = 0;
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (Math.pow(mid, 2) == x) {
                return mid;
            } else if (Math.pow(mid, 2) < x) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (Math.pow(high, 2) <= x) {
            return high;
        } else {
            return low;
        }
    }
}
