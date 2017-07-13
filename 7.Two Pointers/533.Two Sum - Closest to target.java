public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        
        Arrays.sort(nums);
        
        int diff = Integer.MAX_VALUE;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                return 0;
            } else if (nums[l] + nums[r] < target) {
                diff = Math.min(diff, target - nums[l] - nums[r]);
                l++;
            } else {
                diff = Math.min(diff, nums[l] + nums[r] - target);
                r--;
            }
        }
        
        return diff;
    }
}
