package BinarySearch;

public class FindLowestInRotatedArray {
//
//    159. Find Minimum in Rotated Sorted Array
//    Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//            (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//    Find the minimum element.
//
//    Example
//    Given [4, 5, 6, 7, 0, 1, 2] return 0
//
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[end]) { // TODO: use end as breaking point in case 1,2,3
                start = mid;
            } else if (nums[mid] <= nums[end]) {
                end = mid;
            }
        }
        if (nums[start] > nums[end]) {
            return nums[end];
        } else {
            return nums[start];
        }
    }
}
