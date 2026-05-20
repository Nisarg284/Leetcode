/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {


    public static void serialHelper(TreeNode root,StringBuilder ans){
        if(root == null){
            ans.append("N,");
            return;
        }

        ans.append(root.val+",");
        serialHelper(root.left,ans);
        serialHelper(root.right,ans);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        // String []ans = new String[1];
        StringBuilder ans = new StringBuilder();

        serialHelper(root,ans);


        ans.deleteCharAt(ans.length()-1);

        System.out.println(ans);


        return ans.toString();
        
    }

    // Decodes your encoded data to tree.

    public static TreeNode helperDeserial(String[]arr,int[]idx){
        if(arr[idx[0]].equals("N")){
            idx[0]++;
            return null;
        }


        TreeNode curr = new TreeNode(Integer.parseInt(arr[idx[0]]));
        idx[0]++;
        curr.left = helperDeserial(arr,idx);
        curr.right = helperDeserial(arr,idx);

        return curr;
    }
    public TreeNode deserialize(String data) {


        String[]arr = data.split(",");

        int[] idx = {0};

        return helperDeserial(arr,idx);

        

        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));