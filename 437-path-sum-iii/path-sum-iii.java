class Solution {

    public static int helper (TreeNode root,long targetSum)
    {
        if(root == null)
        {
            return 0;
        }

        int count = 0;
        if((long)root.val == targetSum)
        {
            count++;
        }

        return count + helper(root.left,targetSum - (long)root.val) + helper(root.right,targetSum - (long) root.val);
        
        
    }
    public int pathSum(TreeNode root, int targetSum) {

        if(root == null )
        {
            return 0;
        }
    
        int count = helper(root,(long)targetSum);
        
        count += (pathSum(root.left,targetSum) + pathSum(root.right,targetSum));

        return count;

    
        
    }
}




// class Solution {

//   public static int helper(TreeNode root, int targetSum) {
//     if (root == null) {
//       return 0;
//     }

//     int count = 0;
//     if (root.val == targetSum) {
//       count++; // Count path ending at current node
//     }

//     int leftCount = helper(root.left, targetSum - root.val);
//     int rightCount = helper(root.right, targetSum - root.val);

//     return count + leftCount + rightCount;
//   }

//   public int pathSum(TreeNode root, int targetSum) {
//     if (root == null) {
//       return 0;
//     }

//     return helper(root, targetSum);
//   }
// }
