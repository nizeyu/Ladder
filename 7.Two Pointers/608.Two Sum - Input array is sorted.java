// Self
public class Solution {
    /*
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        
        int l = 0; 
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                break;
            } else if(nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        
        return new int[]{l+1, r+1};
    }
}




public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        
        return null;
    }
}
