public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0) {
            return -1;
        }
        
        int index = lowerBound(A, target);
        if(index == 0) {
            return 0;
        }
        
        if(index == A.length) {
            return A.length - 1;
        }
        
        if(A[index] == target) {
            return index;
        }
        
        return (target - A[index-1]) < (A[index] - target) ? index-1 : index;
    }
    
    private int lowerBound(int[] A, int target) {
        int l = 0;
        int r = A.length;
        
        while(l < r) {
            int mid = l + (r - l) / 2;
            
            if(target <= A[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
}
