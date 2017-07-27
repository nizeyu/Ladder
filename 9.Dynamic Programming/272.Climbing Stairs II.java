// Self
public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int climbStairs2(int n) {
        if (n < 2) {
            return 1;
        }
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        return dp[dp.length-1];
    }
}
