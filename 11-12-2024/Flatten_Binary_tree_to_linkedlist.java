/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
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
            root.left = null; 
            return rightTail == null ? leftTail : rightTail;
        }
        
        return rightTail == null ? root : rightTail;
    }
}
