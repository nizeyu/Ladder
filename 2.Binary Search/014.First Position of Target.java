// Self
class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int l = 0;
        int r = nums.length;
        
        while(l < r) {
            int mid = l + (r - l) / 2;
            
            if(target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        if(l == nums.length || nums[l] != target) {
            return -1;
        }
        
        return l;
    }
}
