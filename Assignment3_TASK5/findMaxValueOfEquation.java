import java.util.Deque;
import java.util.LinkedList;
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int maxValue = Integer.MIN_VALUE;
        
        for (int i = 0; i < points.length; i++) {
            while (!deque.isEmpty() && points[i][0] - points[deque.peekFirst()][0] > k) {
                deque.pollFirst();
            }
            if (!deque.isEmpty()) {
                int idx = deque.peekFirst();
                maxValue = Math.max(maxValue, points[i][1] + points[idx][1] + points[i][0] - points[idx][0]);
            }
            while (!deque.isEmpty() && points[deque.peekLast()][1] - points[deque.peekLast()][0] <= points[i][1] - points[i][0]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return maxValue;
    }
}
