class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, currentPath, result);
        return result;
    }


     public static void dfs(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return; // Base case: empty tree or reached a null node
        }

        // Add the current node's value to the path
        currentPath.add(node.val);

        // Check if the current node is a leaf node and if the path sum equals the target sum
        if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(currentPath)); // Add a copy of the current path to the result
        }

        // Recursively traverse the left and right subtrees
        dfs(node.left, targetSum - node.val, currentPath, result);
        dfs(node.right, targetSum - node.val, currentPath, result);

        // Backtrack: remove the current node's value from the path
        currentPath.removeLast();
    }
}


