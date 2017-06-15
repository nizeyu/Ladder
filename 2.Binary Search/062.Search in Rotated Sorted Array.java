public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0) {
           return -1;
        }
        
        int l = 0;
        int r = A.length - 1;
        
        while (l <= r) {
            int m = l + (r - l) / 2;
            
            if(A[m] == target) {
                return m;
            }
            
            if(A[l] < A[m]) {
                if(A[l] <= target && target < A[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (A[l] > A[m]) {
                if(A[m] < target && target <= A[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                l++;
            }
        }
        
        return -1;
    }
}
