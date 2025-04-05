import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a min-heap (priority queue) with a custom comparator that stores the smallest element at the top
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Iterate through each number in the array
        for (int num : nums) {
            minHeap.offer(num);  // Add the current number to the heap
            
            // If the heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // The root of the min-heap is the k-th largest element
        return minHeap.peek();
    }
}
