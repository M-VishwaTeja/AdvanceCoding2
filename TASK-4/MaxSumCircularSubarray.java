class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSubarraySum = nums[0], minSubarraySum = nums[0];
        int currentMaxSum = nums[0], currentMinSum = nums[0], totalSum = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            totalSum += nums[i];
            currentMaxSum = nums[i] + Math.max(currentMaxSum, 0);
            maxSubarraySum = Math.max(maxSubarraySum, currentMaxSum);
            currentMinSum = nums[i] + Math.min(currentMinSum, 0);
            minSubarraySum = Math.min(minSubarraySum, currentMinSum);
        }

        return maxSubarraySum > 0 ? Math.max(maxSubarraySum, totalSum - minSubarraySum) : maxSubarraySum;
}}
