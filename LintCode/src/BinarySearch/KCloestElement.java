package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class KCloestElement {

//    460. Find K Closest Elements
//    Given a target number, a non-negative integer k and an integer array A sorted in ascending order, find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target. Otherwise, sorted in ascending order by number if the difference is same.
//
//    Example
//    Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].
//
//    Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].
//
//    Challenge
//    O(logn + k) time complexity.
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        int[] res = new int[k];
        if (A == null || A.length == 0 || k == 0) {
            return res;
        }
        int start = 0, end = A.length - 1, mid = 0;
        int index = -1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                index = mid;
                break;
            } else if (A[mid] < target){
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            index = start;
        }
        if (A[end] == target) {
            index = end;
        }
        if (index == -1) {
            index = Math.abs(A[start] - target) <= Math.abs(A[end] - target) ? start : end;
        }
        res[res.length - k--] = A[index];
        start = index - 1;
        end = index + 1;
        while (start >= 0 && end < A.length && k > 0) {
            int startAbs = Math.abs(A[start] - target);
            int endAbs = Math.abs(A[end] - target);
            if (startAbs <= endAbs) {
                res[res.length - k--] = A[start--];
            } else {
                res[res.length - k--] = A[end++];
            }
        }
        while (start >= 0 && k > 0) {
            res[res.length - k--] = A[start--];
        }
        while (end < A.length && k > 0) {
            res[res.length - k--] = A[end++];
        }
        Set<Integer> ss = new HashSet<>();
        int[] sd = ss.stream().mapToInt(e -> e).toArray();
        ss = Arrays.stream(sd).boxed().collect(Collectors.toSet());
        return res;
    }
}
