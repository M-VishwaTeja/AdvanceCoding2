import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the input values
        int n = sc.nextInt();  // n is the length of the domino (2xN board)
        
        // Edge case for n == 1
        if (n == 1) {
            System.out.println(1);
            return;
        }
        // Array to store the number of ways to tile a 2xN grid
        long[] dp = new long[n + 1];

        // Base cases
        dp[0] = 1;  // 1 way to fill a 2x0 grid (nothing to place)
        dp[1] = 1;  // 1 way to fill a 2x1 grid (1 vertical domino)
        // Fill the dp array based on the recurrence relation
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // Output the result for the given n
        System.out.println(dp[n]);
    }
}
