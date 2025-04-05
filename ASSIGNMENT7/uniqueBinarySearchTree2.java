import java.util.*;
public class Solution {
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generateTrees(1, n);
    }

    // Helper function to generate trees from start to end
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        
        // Base case: if start > end, return a list with a null element (empty tree)
        if (start > end) {
            trees.add(null);
            return trees;
        }

        // Try every number as the root
        for (int i = start; i <= end; i++) {
            // Generate all possible left subtrees with values from start to i-1
            List<TreeNode> leftSubtrees = generateTrees(start, i - 1);
            // Generate all possible right subtrees with values from i+1 to end
            List<TreeNode> rightSubtrees = generateTrees(i + 1, end);
            
            // Combine each left and right subtree with i as root
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
