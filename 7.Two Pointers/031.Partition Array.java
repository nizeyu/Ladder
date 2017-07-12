public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
	    int l = 0;
	    int r = nums.length - 1;
	    while (l < r) {
	        while (l < r && nums[r] >= k) {
	            r--;
	        }
	        
	        while (l < r && nums[l] < k) {
	            l++;
	        }
	        
	        int temp = nums[l];
	        nums[l] = nums[r];
	        nums[r] = temp;
	        
	    }
	    
	    if (nums[l] >= k) {
	        return l;
	    }
	    
	    return l + 1;
    }
}
