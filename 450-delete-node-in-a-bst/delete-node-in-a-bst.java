class Solution {

    public static TreeNode  IOP(TreeNode root)
    {
        // once go left
        TreeNode pred = root.left;

        // go right until pred.right != null
        while(pred.right != null)
        {
            pred = pred.right; 
        }
        return null;

    }

    public static TreeNode  IOS(TreeNode root)
    {
        // once go right
        TreeNode succ = root.right;

        // go left until pred.left != null
        while(succ.left != null)
        {
            succ = succ.left; 
        }
        return succ;

    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
        {
            return null;
        }

        if(root.val == key)
        {
            // Case 1: delete Leaf node
            if(root.left == null && root.right == null)
            {
               // root = null;
                return null;
            }

            // case 2: root has only 1 child node
            if(root.left == null || root.right == null)
            {
                // find not null node
                if(root.left != null)
                {
                    return root.left;
                }

                if(root.right != null)
                {
                    return root.right;
                }
            }

            // Case 3: root has 2 child nodes
            if(root.left != null && root.right != null)
            {
                // find predecessor  / successor  
                TreeNode succ = IOS(root);

                // Replace root value with pred value
                root.val = succ.val;

                // delete pred node from left side of tree
                root.right = deleteNode(root.right,succ.val);

                //return root; 
            }

        }
      
        // if root.val > key so go left
        else if(root.val > key)
        {
            // attached & call left subtree
           root.left = deleteNode(root.left,key);

        }
        else
        { //  root.val < key,  so go right

            // attached & call right subtree
            root.right = deleteNode(root.right,key);

        }
        return root;

    }
}




// class Solution {

//     public static TreeNode IOP(TreeNode root) {
//         // once go left
//         TreeNode pred = root.left;

//         // go right until pred.right == null
//         while (pred.right != null) {
//             pred = pred.right;
//         }
//         return pred;
//     }

//     public static TreeNode IOS(TreeNode root) {
//         // once go right
//         TreeNode succ = root.right;

//         // go left until succ.left == null
//         while (succ.left != null) {
//             succ = succ.left;
//         }
//         return succ;
//     }

//     public TreeNode deleteNode(TreeNode root, int key) {
//         if (root == null) {
//             return null;
//         }

//         if (root.val == key) {
//             // Case 1: delete Leaf node
//             if (root.left == null && root.right == null) {
//                 return null;
//             }

//             // Case 2: root has only 1 child node
//             if (root.left == null) {
//                 return root.right;
//             }

//             if (root.right == null) {
//                 return root.left;
//             }

//             // Case 3: root has 2 child nodes
//             // Find successor
//             TreeNode succ = IOS(root);
//             // Replace root value with succ value
//             root.val = succ.val;
//             // Delete succ node from right side of tree
//             root.right = deleteNode(root.right, succ.val);
//         } else if (root.val > key) {
//             // if root.val > key go left
//             root.left = deleteNode(root.left, key);
//         } else {
//             // root.val < key, go right
//             root.right = deleteNode(root.right, key);
//         }
//         return root;
//     }
// }






