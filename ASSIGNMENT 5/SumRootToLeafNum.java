class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        // Base case: if the node is null, return 0
        if (node == null) {
            return 0;
        }
        
        // Update the current sum (multiply the previous sum by 10 and add the node's value)
        currentSum = currentSum * 10 + node.val;
        
        // If it's a leaf node, return the current sum
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        
        // Recursively calculate the sum for the left and right subtree
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}
