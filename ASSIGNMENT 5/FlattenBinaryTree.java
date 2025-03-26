class Solution {
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }
    
    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftTail = flattenHelper(root.left);
        TreeNode rightTail = flattenHelper(root.right);
        
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null; // Set the left child to null
            
            return rightTail == null ? leftTail : rightTail;
        }
        
        // If no left subtree, just return the right tail (or root itself if no right)
        return rightTail == null ? root : rightTail;
    }
}
