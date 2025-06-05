/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public static void parentMapper(TreeNode root,HashMap<TreeNode,List<TreeNode>> parent)
    {

        if(root == null)
        {
            return;
        }

        if(!parent.containsKey(root))
        {
            parent.put(root,new ArrayList<>());
        }

        if(root.left != null && !parent.containsKey(root.left))
        {
            parent.put(root.left,new ArrayList<>());
            parent.get(root.left).add(root);

        }

        if(root.right != null && !parent.containsKey(root.right))
        {
            parent.put(root.right,new ArrayList<>());
            parent.get(root.right).add(root);
        }

        if(root.left != null)
        {
            parent.get(root).add(root.left);
        }

        if(root.right != null)
        {
            parent.get(root).add(root.right);
        }


        parentMapper(root.left,parent);
        parentMapper(root.right,parent);
        

    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {


        HashMap<TreeNode,List<TreeNode>> parent = new HashMap<>();
        // parent.put(root,new ArrayList<>());

        parentMapper(root,parent);

        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        Set<TreeNode> vis = new HashSet<>();
        vis.add(target);

        q.add(target);

        int level = 0;

        while(!q.isEmpty() )
        {
            int size = q.size();
            for(int i = 0;i<size;i++)
            {
                TreeNode curr = q.remove();
                if(level == k)
                {
                    res.add(curr.val);
                }
                for(TreeNode child : parent.get(curr))
                {
                    if(!vis.contains(child))
                    {
                        vis.add(child);
                        q.add(child);

                        // if(k == 0)
                        // {
                        //     res.add(child.val);
                        // }
                    }
                }
            }
            
            level++;
        }


        // System.out.println(parent);

        for(TreeNode curr : parent.keySet())
        {
            System.out.print(curr.val+" : ");

            for(TreeNode child : parent.get(curr) )
            {
                System.out.print(child.val+"->");
            }
            System.out.println();
        }

        return res;
        
    }
}