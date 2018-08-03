package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class BITree {

//    249. Count of Smaller Number before itself
//    Give you an integer array (index from 0 to n-1, where n is the size of this array, data value from 0 to 10000) . For each element Ai in the array, count the number of element before this element Ai is smaller than it and return count number array.
//
//            Example
//    For array [1,2,7,8,5], return [0,1,2,3,2]

    /**
     * @param A: an integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (A == null || A.length == 0) {
            return res;
        }
        int[] bitree = new int[10001];
        for (int num : A) {
            int count = 0;
            if (num > 0) {
                count = query(bitree, num);
            }
            modify(bitree, num);
            res.add(count);
        }
        return res;
    }

    // TODO: lowbit cannot input 0!!!!!!!
    private void modify(int[] bitree, int num) {
        for (int i = num + 1; i < bitree.length; i = i + lowbit(i)) {
            bitree[i]++;
        }
    }

    private int query(int[] bitree, int num) {
        int count = 0;
        for (int i = num; i > 0; i = i - lowbit(i)) {
            count += bitree[i];
        }
        return count;
    }
    private int lowbit(int i) {
        return i & (-i);
    }
}
