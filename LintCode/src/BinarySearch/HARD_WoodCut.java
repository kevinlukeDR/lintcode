package BinarySearch;

public class HARD_WoodCut {


//    183. Wood Cut
//    Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.
//
//            Example
//    For L=[232, 124, 456], k=7, return 114.
//
//    Challenge
//    O(n log Len), where Len is the longest length of the wood.
//
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }
        int start = 1, end = 0, mid = 0;
        for (int l : L) {
            end = Math.max(end, l);
        }
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (count(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (count(L, end) >= k) {
            return end;
        } else if (count(L, start) >= k) {
            return start;
        } else {
            return 0;
        }
    }

    private int count(int[] L, int mod) {
        int count = 0;
        for (int l : L) {
            count += l / mod;
        }
        return count;
    }

}
