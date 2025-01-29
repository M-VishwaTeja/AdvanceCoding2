import java.util.*;
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new ArrayDeque<>(); 
        dp[0] = nums[0];
        deque.offer(0);

        for (int i = 1; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            dp[i] = Math.max(nums[i], nums[i] + dp[deque.peekFirst()]);
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.offer(i);
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
