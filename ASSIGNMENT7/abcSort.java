import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //number of elements in the array
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Applying the three-pointer technique (Dutch National Flag Problem)
        int left = 0;        // Pointer for 'A'
        int right = n - 1;   // Pointer for 'C'
        int middle = 0;      // Pointer to traverse the array
        
        while (middle <= right) {
            if (arr[middle] == 1) {
                // 1 represents 'A', move it to the left part
                swap(arr, left, middle);
                left++;
                middle++;
            } else if (arr[middle] == 2) {
                // 2 represents 'B', leave it in the middle part
                middle++;
            } else {
                // 3 represents 'C', move it to the right part
                swap(arr, middle, right);
                right--;
            }
        }
        
        // Output the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    // Utility function to swap elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
