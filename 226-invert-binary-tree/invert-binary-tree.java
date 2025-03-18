class Solution {

    // public static void helper(TreeNode root)
    // {
    //     if(root == null)
    //     {
    //         return;
    //     }

    //     TreeNode temp = root.left;
    //     root.left = root.right;
    //     root.right = temp;

    //     // recursive call for left & right subtree
    //     helper(root.left);
    //     helper(root.right);
    // }
    public TreeNode invertTree(TreeNode root) {

        // helper(root);
        // return root;

        if(root == null)
        {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
        
    }
}