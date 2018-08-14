package BinarySearch;

import java.util.Arrays;

public class Heaters {
//    1219. Heaters
//    Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
//
//            Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.
//
//            So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
//
//    Example
//    Example 1:
//
//    Input: [1,2,3],[2]
//    Output: 1
//    Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
//            Example 2:
//
//    Input: [1,2,3,4],[1,4]
//    Output: 1
//    Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
    /**
     * @param houses: positions of houses
     * @param heaters: positions of heaters
     * @return: the minimum radius standard of heaters
     */
    public int findRadius(int[] houses, int[] heaters) {
        // Write your code here
        Arrays.sort(heaters);
        int res = Integer.MIN_VALUE;
        for (int house : houses) {
            int closestDistance = findClosest(house, heaters);
            res = Math.max(res, closestDistance);
        }
        return res;
    }
    private int findClosest(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return Integer.MAX_VALUE;
        int start = 0, end = nums.length - 1, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return 0;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.min(Math.abs(nums[start] - target), Math.abs(nums[end] - target));
    }
}
