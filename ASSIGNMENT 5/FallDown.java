import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of rows and columns
        int n = sc.nextInt(); // number of rows
        int m = sc.nextInt(); // number of columns
        
        // Initialize the grid
        char[][] grid = new char[n][m];
        
        // Reading the grid
        sc.nextLine();  // consume the remaining newline
        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }
        
        // Process each column to simulate gravity
        for (int col = 0; col < m; col++) {
            // Count the number of blocks in the current column
            int blockCount = 0;
            for (int row = 0; row < n; row++) {
                if (grid[row][col] == '*') {
                    blockCount++;
                }
            }
            
            // Fill the column from the bottom upwards with blocks
            for (int row = n - 1; row >= 0; row--) {
                if (blockCount > 0) {
                    grid[row][col] = '*';
                    blockCount--;
                } else {
                    grid[row][col] = '.';
                }
            }
        }
        
        // Print the final grid after applying gravity
        for (int i = 0; i < n; i++) {
            System.out.println(new String(grid[i]));
        }
        
        sc.close();
    }
}
