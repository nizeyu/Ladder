//Self
public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int l = 0;
        int r = m * n;
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            
            if (target <= matrix[mid/n][mid%n]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        if (l == m * n || matrix[l/n][l%n] != target) {
            return false;
        }
        
        return true;
    }
}
