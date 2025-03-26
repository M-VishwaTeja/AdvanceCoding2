import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Scanner to read the input
        Scanner sc = new Scanner(System.in);

        // Reading number of elements and number of queries
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Array to store the elements
        long[] a = new long[n];

        // Reading the elements into the array
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        // Sorting the array to allow efficient querying
        Arrays.sort(a);

        // Processing each query
        for (int i = 0; i < m; i++) {
            // Read the query
            long x = sc.nextLong();

            // Binary search for the smallest element greater than or equal to x
            int idx = binarySearch(a, x);

            // If idx is n, then no element is >= x
            if (idx == n) {
                System.out.println(0);
            } else {
                // Otherwise, we need to calculate the sum of elements from idx to the end
                long sum = 0;
                for (int j = idx; j < n; j++) {
                    sum += a[j];
                }
                System.out.println(sum);
            }
        }

        sc.close();
    }

    // Binary search to find the first element >= x
    private static int binarySearch(long[] a, long x) {
        int left = 0, right = a.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
