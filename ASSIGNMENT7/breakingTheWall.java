import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of blocks and the target height
        int n = sc.nextInt(); // Number of blocks in the wall
        int targetHeight = sc.nextInt(); // The target height to break the blocks to
        
        // Read the heights of the blocks
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        
        // Sort the heights in ascending order
        // Sorting helps in minimizing the number of steps needed to break all blocks
        java.util.Arrays.sort(heights);
        
        // Count the number of steps needed
        int steps = 0;
        for (int i = 0; i < n; i++) {
            // If a block's height is greater than the target height, we need to break it down
            if (heights[i] > targetHeight) {
                steps += (heights[i] - targetHeight);
            }
        }
        
        // Output the minimum number of steps required
        System.out.println(steps);
    }
}
