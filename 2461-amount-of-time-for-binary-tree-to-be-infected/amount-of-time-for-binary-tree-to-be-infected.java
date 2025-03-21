class Solution {

    public static TreeNode search(TreeNode root,int start)
    {
        if(root == null)
        {
            return null;
        }

        if(root.val == start)
        {
            return root;
        }

        TreeNode left = search(root.left,start);
        if(left != null)
        {
            return left;
        }

        return search(root.right,start);
    }

    public static void parentMapping(TreeNode root,HashMap<TreeNode,TreeNode> hm)
    {
        if(root == null || root.left == null && root.right == null)
        {
            return;
        }

        if(root.left!=null)
        {
            hm.put(root.left,root);
        }

        if(root.right!=null)
        {
            hm.put(root.right,root);
        }

        parentMapping(root.left,hm);
        parentMapping(root.right,hm);
    }
    public int amountOfTime(TreeNode root, int start) {

        if(root == null)
        {
            return 0;
        }

        TreeNode firstInfected = search(root,start);

        // Define parent Map
        HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();
        parentMapping(root,parentMap);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(firstInfected);

        HashMap<TreeNode,Integer> timingMap = new HashMap<>();
        timingMap.put(firstInfected,0);

        HashSet<TreeNode> infected = new HashSet<>();
        infected.add(firstInfected);

        int maxTiming = 0;

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i =0;i<size;i++)
            {
                TreeNode curr = q.remove();

                TreeNode parent = parentMap.get(curr);

                if(parentMap.containsKey(curr) && !infected.contains(parent))
                {
                    q.add(parent);
                    timingMap.put(parent,timingMap.get(curr)+1);
                    infected.add(parent);
                }

                if(curr.left != null && !infected.contains(curr.left) )
                {
                    q.add(curr.left);
                    timingMap.put(curr.left,timingMap.get(curr)+1);
                    infected.add(curr.left);
                }

                if(curr.right != null && !infected.contains(curr.right) )
                {
                    q.add(curr.right);
                    timingMap.put(curr.right,timingMap.get(curr)+1);
                    infected.add(curr.right);
                }
            }
            maxTiming ++;
        }
        return maxTiming -1;        
    }
}