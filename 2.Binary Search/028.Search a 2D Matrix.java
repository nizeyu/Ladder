//My Solution
public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        
        return lowerbound(matrix, target);
    }
    
    private boolean lowerbound (int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int l = 0; 
        int r = m * n - 1;
        
        while(l < r) {
            int mid = l + (r - l) / 2;
            int i = mid / n;
            int j = mid % n;
            
            if (matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        if (matrix[l / n][l % n] == target) {
            return true;
        } else if (matrix[r / n][r % n] == target) {
            return true;
        }
        
        return false;
    }
}
