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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
         // If tree is empty, return empty list
         if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); // Start with root

        while (!q.isEmpty()) {
            // How many nodes in current level
            int levelSize = q.size(); 
            List<Integer> currentLevel = new ArrayList<>();

            // Process all nodes of current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.remove(); 
                currentLevel.add(node.val);   

                
                if (node.left != null) q.add(node.left);
                
                if (node.right != null) q.add(node.right);
            }
            result.add(currentLevel); 
        }

        Collections.reverse(result);
        return result;
    }
}