package BinarySearch;

public class InfiniteSortedFindTarget {
    /**
     * @param nums:   The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return findPosition(nums, target);
    }

    private int findPosition(int[] nums, int target) {
        int low = 0, high = 1;
        int cur = nums[0];
        while (cur < target) {
            low = high;
            high = high * 2;
            cur = nums[high];
        }
        return search(nums, low, high, target);
    }

    private int search(int[] nums, int low, int high, int target) {
        int mid = 0;
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid;
            } else if (nums[mid] > target) {
                high = mid;
            } else {
                high = mid;
            }
        }
        if (nums[low] == target) {
            return low;
        } else if (nums[high] == target) {
            return high;
        } else {
            return -1;
        }
    }

}
