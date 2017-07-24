// Self
public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) {
            return new int[]{-1, -1};
        }
        
        int l = lowerBound(A, target);
        int r = upperBound(A, target);
        
        if (l == A.length || A[l] != target) { // 检查上边界 和 值是否相等
            return new int[]{-1, -1};
        }
        
        return new int[]{l, r-1};
    }
    
    private int lowerBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        } 

        return l;
    }

    private int upperBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (target < nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
