// two pointer: O(nlogn) time, O(1) extra space
public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[len]) {
                len++;
                nums[len] = nums[i];
            }
        }
        
        return len + 1;
    }
}

// HashMap: // O(n) time, O(n) space
public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        HashMap<Integer, Boolean> mp = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; ++i) {
            mp.put(nums[i], true);
        }

        int result = 0;
        for (Map.Entry<Integer, Boolean> entry : mp.entrySet()) {
            nums[result++] = entry.getKey();
        }
        
        return result;
    }
}
