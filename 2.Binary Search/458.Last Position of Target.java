public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int lastPosition(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        return upperbound(nums, target);
    }
    
    private static int upperbound(int[] nums, int target) {
		int l = 0;
		int r = nums.length;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(target >= nums[mid])
                l = mid + 1;
            else
                r = mid;
        }
        
        if(l > 0 && nums[l-1] == target) {
            return l - 1;
        }
        
        return -1;
    }
}
