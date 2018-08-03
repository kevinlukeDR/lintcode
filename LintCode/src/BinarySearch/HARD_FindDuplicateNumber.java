package BinarySearch;
//
//633. Find the Duplicate Number
//        Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
//
//        Example
//        Given nums = [5,5,4,3,2,1] return 5
//        Given nums = [5,4,4,3,2,1] return 4
public class HARD_FindDuplicateNumber {
    //TODO Allow to modify array (O(n))
    public int findDuplicate(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length;) {
            int index = nums[i];
            int temp = nums[index - 1];
            if (temp == index) {
                if (i == index - 1) {
                    i++;
                    continue;
                }
                return temp;
            }
            nums[index - 1] = index;
            nums[i] = temp;
        }
        return 0;
    }

    //TODO Do not allow to modify (O(n))
    //TODO Details: https://blog.csdn.net/wr339988/article/details/53617914
//    2[a+(k1L+x)]=a+(k2L+x)
//    a+2k1L+x=k2L
//    a+x=(k2-2k1)L
//    a+L-b=(k2-2k1)L
//    a=(k2-2k2-1)L+b
//    a=CL+b
    public int findDuplicate2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                break;
            }
        }
        fast = 0;
        while (true) {
            fast = nums[fast];
            slow = nums[slow];
            if (fast == slow) {
                return fast;
            }
        }
    }
}
