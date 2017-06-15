public class Solution {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     */
    public int mountainSequence(int[] nums) {
        // Write your code here
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i+1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
