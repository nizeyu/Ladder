class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int i = 0;
        int l = 0;
        int r = nums.length - 1;
        while (i <= r) {
            if (nums[i] == 0) {
                swap(i, l, nums);
                l++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(i, r, nums);
                r--;
            }
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
