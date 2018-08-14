package Math;

public class ArrageCoins {
//    988. Arranging Coins
//    You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
//
//    Given n, find the total number of full staircase rows that can be formed.
//
//    n is a non-negative integer and fits within the range of a 32-bit signed integer.
//
//            Example
//    Example 1:
//
//    n = 5
//
//    The coins can form the following rows:
//    ¤
//    ¤ ¤
//    ¤ ¤
//
//    Because the 3rd row is incomplete, we return 2.
//    Example 2:
//
//    n = 8
//
//    The coins can form the following rows:
//    ¤
//    ¤ ¤
//    ¤ ¤ ¤
//    ¤ ¤
//
//    Because the 4th row is incomplete, we return 3.
    /**
     * @param n: a non-negative integer
     * @return: the total number of full staircase rows that can be formed
     */
    public int arrangeCoins(int n) {
        // Write your code here
        return (int) ((-1L + Math.sqrt(1L + 8L * (long) n)) / 2L);
    }
}
