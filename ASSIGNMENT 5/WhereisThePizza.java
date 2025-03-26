import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        int n = sc.nextInt(); // Number of rows
        int m = sc.nextInt(); // Number of columns
        
        // Read the initial position of the pizza (1-indexed)
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        // Read the number of movements
        int q = sc.nextInt();
        
        // Process each movement instruction
        for (int i = 0; i < q; i++) {
            String direction = sc.next();
            
            // Move pizza based on the direction
            switch (direction) {
                case "UP":
                    if (x > 1) x--; // Move up if not at the top row
                    break;
                case "DOWN":
                    if (x < n) x++; // Move down if not at the bottom row
                    break;
                case "LEFT":
                    if (y > 1) y--; // Move left if not at the first column
                    break;
                case "RIGHT":
                    if (y < m) y++; // Move right if not at the last column
                    break;
            }
        }
        
        // Output the final position of the pizza (1-indexed)
        System.out.println(x + " " + y);
        
        sc.close();
    }
}
