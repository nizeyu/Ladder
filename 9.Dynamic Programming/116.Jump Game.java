// Self: DP
public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        
        boolean[] dp = new boolean[A.length];
        dp[0] = true;
        
        for (int i = 0; i < dp.length; i++) {
            if (!dp[i]) {
                continue;
            }
            
            for (int j = 1; j <= A[i]; j++) {
                if (i + j < A.length && !dp[i+j]) {
                    dp[i+j] = true;
                }
            }
        }
        return dp[dp.length-1];
    }
}
