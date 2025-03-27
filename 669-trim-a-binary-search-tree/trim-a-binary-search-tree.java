class Solution {

    // public static void trim(TreeNode root, int low, int high) {
    //     // Base case
    //     if (root == null) {
    //         return;
    //     }

    //     while (root.left != null) 
    //     {
    //         if (root.left.val < low) 
    //         {
    //             root.left = root.left.right;
    //         } 
    //         else if (root.left.val > high) 
    //         {
    //             root.left = root.left.left;
    //         } 
    //         else 
    //         {
    //             break;
    //         }
    //     }

    //         while (root.right != null) 
    //         {

    //             if (root.right.val < low) 
    //             {
    //                 root.right = root.right.right;
    //             } 
    //             else if (root.right.val > high) 
    //             {
    //                 root.right = root.right.left;
    //             } 
    //             else 
    //             {
    //                 break;
    //             }

    //         }

    //         trim(root.left,low,high);
    //         trim(root.right,low,high);

        
    // }


   public static TreeNode trim(TreeNode root, int low, int high)
   {
    if(root == null)
    {
        return null;
    }

    if(root.val < low)
    {
        return trim(root.right,low,high);
    }

    if(root.val > high)
    {
        return trim(root.left,low,high);
    }

    root.left = trim(root.left,low,high);
    root.right = trim(root.right,low,high);
    return root;
   }
    

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null)
        {
            return null;
        }

        // create a dummy node & connect root to its left part
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
        dummy.left = root;

        // call trim function
        return trim(root,low,high);
        

       // return dummy.left;

    }
    }
