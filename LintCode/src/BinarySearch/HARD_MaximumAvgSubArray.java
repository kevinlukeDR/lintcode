package BinarySearch;

//617. Maximum Average Subarray II
//        Given an array with positive and negative numbers, find the maximum average subarray which length should be greater or equal to given length k.
//
//        Example
//        Given nums = [1, 12, -5, -6, 50, 3], k = 3
//
//        Return 15.667 // (-6 + 50 + 3) / 3 = 15.667
//
//        Notice
//        It's guaranteed that the size of the array is greater or equal to k.

public class HARD_MaximumAvgSubArray {
    /*
     * @param nums: an array with positive and negative numbers
     * @param k: an integer
     * @return: the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0 || k == 0) {
            return 0D;
        }
        double start = -1e12, end = 1e12, unit = 1e-6;
        while (start + unit < end) {
            double mid = start + (end - start) / 2;
            if (check(nums, mid, k)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (start == -0.00D || end == -0.00D) {
            return 0D;
        }
        if (check(nums, start, k)) {
            return start;
        } else {
            return end;
        }
    }
    // TODO sum array to calculate sum of i to j
    private boolean check(int[] nums, double avg, int k) {
        double min = Double.MAX_VALUE;
        double[] sum = new double[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1] - avg;
            if (i >= k) {
                min = Math.min(min, sum[i - k]);
                // TODO here means there is a subarray avg bigger than avg (if avg is biggest, all subarray sum of (nums[i] - avg) should less than 0)
                if (sum[i] - min > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
