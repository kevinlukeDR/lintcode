package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS {
//    76. Longest Increasing Subsequence
//    Given a sequence of integers, find the longest increasing subsequence (LIS).
//
//    You code should return the length of the LIS.
//
//            Example
//    For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
//    For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4
//
//    Challenge
//    Time complexity O(n^2) or O(nlogn)
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */

    // O(n^2)
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        // Definition: dp[i] is 0 - i including i, longest LIS's length
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    // O(nlogn)
    // Maintain a increasing list, and using binary search to check index needs to be replaced
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.size() == 0) {
                list.add(num);
                continue;
            }
            if (num < list.get(0)) {
                list.set(0, num);
            } else if (num > list.get(0) && num < list.get(list.size() - 1)) {
                int index = binarySearch(list, num);
                list.set(index, num);
            } else if (num > list.get(list.size() - 1)) {
                list.add(num);
            }
        }
        return list.size();
    }
    private int binarySearch(List<Integer> list, int num) {
        int start = 0, end = list.size() - 1, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (list.get(mid) >= num) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (list.get(start) >= num) {
            return start;
        } else {
            return end;
        }
    }
}
