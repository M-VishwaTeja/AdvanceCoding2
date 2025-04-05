class Solution {
    private TreeNode first = null, second = null, prev = null;

    public void recoverTree(TreeNode root) {
        inorderTraversal(root);

        // Swap the values of the two nodes that are out of order
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    // In-order traversal to find the two nodes that are swapped
    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        // Traverse the left subtree
        inorderTraversal(root.left);

        // Check the current node
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                // This is the first violation
                first = prev;
            }
            // This is the second violation
            second = root;
        }

        // Update the previous node
        prev = root;

        // Traverse the right subtree
        inorderTraversal(root.right);
    }
}
