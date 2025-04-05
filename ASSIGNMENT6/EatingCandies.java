import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of candies
            int[] w = new int[n]; // Candy weights
            
            // Reading the weights
            for (int i = 0; i < n; i++) {
                w[i] = sc.nextInt();
            }
            
            int i = 0, j = n - 1;
            int aliceWeight = 0, bobWeight = 0;
            int maxCandies = 0;
            
            // Two pointers technique
            while (i <= j) {
                if (aliceWeight < bobWeight) {
                    aliceWeight += w[i++];
                } else if (aliceWeight > bobWeight) {
                    bobWeight += w[j--];
                } else {
                    maxCandies = Math.max(maxCandies, i + (n - j - 1));
                    aliceWeight += w[i++];
                }
            }
            System.out.println(maxCandies);
        }
        sc.close();
    }
}
