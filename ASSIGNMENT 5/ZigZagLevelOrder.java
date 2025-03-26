import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // If the root is null, return an empty list
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;  // Flag to indicate the direction
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelValues = new ArrayList<>();
            
            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    levelValues.add(node.val);
                } else {
                    levelValues.add(0, node.val);  // Add to the front for right to left
                }
                
                // Add child nodes to the queue for the next level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            // Add the current level's values to the result
            result.add(levelValues);
            // Toggle the direction for the next level
            leftToRight = !leftToRight;
        }
        
        return result;
    }
}
