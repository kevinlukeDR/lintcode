package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//602. Russian Doll Envelopes
//        You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
//
//        What is the maximum number of envelopes can you Russian doll? (put one inside other)
//
//        Example
//        Given envelopes = [[5,4],[6,4],[6,7],[2,3]],
//        the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
// TODO Same strategy as LIS, binarySearch to logn
public class RussianDollEnvelopes {
    private Comparator<int[]> comparator = new Comparator<int[]>(){
        public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        }
    };
    /*
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] sd) {
        // write your code here
        if (sd == null || sd.length == 0 || sd[0].length != 2) {
            return 0;
        }
        // TODO: Sort
        Arrays.sort(sd, comparator);
        int max = 1;
        int[] dp = new int[sd.length];
        List<Integer> res = new ArrayList<>();
        for (int[] arr : sd) {
            if (res.size() == 0) {
                res.add(arr[1]);
                continue;
            }
            if (res.get(0) > arr[1]) {
                res.set(0, arr[1]);
            } else if (res.get(res.size() - 1) < arr[1]) {
                res.add(arr[1]);
            } else {
                // TODO BinarySearch for first number bigger than target
                insert(res, arr[1]);
            }
        }
        return res.size();
    }
    private void insert(List<Integer> res, int i) {
        int start = 0, end = res.size() - 1, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (res.get(mid) < i) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (res.get(start) >= i) {
            res.set(start, i);
        } else {
            res.set(end, i);
        }
    }
}
