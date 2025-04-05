import java.util.*;

class MedianFinder {
    // Max heap (low) stores the smaller half of the numbers
    private PriorityQueue<Integer> low;
    // Min heap (high) stores the larger half of the numbers
    private PriorityQueue<Integer> high;
    
    public MedianFinder() {
        low = new PriorityQueue<>(Collections.reverseOrder()); // Max heap
        high = new PriorityQueue<>(); // Min heap
    }
    
    public void addNum(int num) {
        // Add to max heap (low)
        if (low.isEmpty() || num <= low.peek()) {
            low.offer(num);
        } else {
            high.offer(num);
        }
        
        // Rebalance the heaps if necessary
        if (low.size() > high.size() + 1) {
            high.offer(low.poll());
        } else if (high.size() > low.size()) {
            low.offer(high.poll());
        }
    }
    
    public double findMedian() {
        if (low.size() > high.size()) {
            return low.peek();
        } else {
            return (low.peek() + high.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
