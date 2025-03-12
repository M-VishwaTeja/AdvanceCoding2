class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        
        dp[0] = 1; 
        dp[1] = 1; 
        
        // Fill the dp array for values from 2 to n
        for (int i = 2; i <= n; i++) {
            // Calculate dp[i] by considering each node as the root
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        
        return dp[n];
    }
}
