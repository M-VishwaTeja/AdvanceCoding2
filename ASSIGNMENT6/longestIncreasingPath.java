class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // dp array to store the longest increasing path starting from (i, j)
        int[][] dp = new int[m][n];
        
        // Direction vectors for up, down, left, right movements
        int[] dirs = {-1, 0, 1, 0, -1}; // This represents (up, right, down, left)
        
        // Helper function for DFS with memoization
        int dfs(int i, int j) {
            // If we already have computed the longest path from (i, j), return it
            if (dp[i][j] != 0) {
                return dp[i][j];
            }
            
            // Initially, the longest path starting from (i, j) is just the cell itself
            dp[i][j] = 1;
            
            // Explore all four possible directions (up, down, left, right)
            for (int d = 0; d < 4; d++) {
                int ni = i + dirs[d];
                int nj = j + dirs[d + 1];
                
                // Check if the new position is within bounds and the number is greater (increasing path)
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] > matrix[i][j]) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dfs(ni, nj));
                }
            }
            
            return dp[i][j];
        }
        
        // Loop through each cell and apply DFS to find the longest path
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, dfs(i, j));
            }
        }
        
        return maxLength;
    }
}
