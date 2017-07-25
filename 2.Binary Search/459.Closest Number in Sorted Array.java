// Self: lowerBound
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int l = 0;
        int r = A.length;
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            
            if (target <= A[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        if (l == A.length) {
            return l - 1;
        }
        
        if (l == 0) {
            return l;
        }
        
        return A[l] - target < target - A[l-1] ? l : l - 1;
    }
}
