// Self
public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int[] dp = new int[A.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) { // 无法到达该点
                continue;
            }
            
            for (int j = 1; j <= A[i]; j++) {
                if (i + j >= dp.length) {
                    break;
                }
                
                dp[i+j] = Math.min(dp[i+j], dp[i] + 1);
            }
            
        }
        
        if (dp[dp.length-1] == Integer.MAX_VALUE) {
            return -1;
        }
        
        return dp[dp.length-1];
    }
}
