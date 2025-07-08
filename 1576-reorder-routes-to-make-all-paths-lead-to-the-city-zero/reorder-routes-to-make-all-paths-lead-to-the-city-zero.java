class Solution {


    public static void dfsHelper(int start, HashMap<Integer,List<Integer>> outgoing,HashMap<Integer,List<Integer>> incoming,int[]ans,HashSet<Integer> vis)
    {
        vis.add(start);

        List<Integer> out = outgoing.get(start);

        if(out != null)
        {
            for(int i : out)
            {
                if(!vis.contains(i))
                {
                    ans[0]++;
                    dfsHelper(i,outgoing,incoming,ans,vis);
                }
            }
        }

        List<Integer> in = incoming.get(start);
        if(in != null)
        {
            for(int i : in)
            {
                if(!vis.contains(i))
                {
                    dfsHelper(i,outgoing,incoming,ans,vis);
                }
            }
        }

    }
    public int minReorder(int n, int[][] connections) {

        int len = connections.length;
        

        HashMap<Integer,List<Integer>> outgoing = new HashMap<>();
        HashMap<Integer,List<Integer>> incoming = new HashMap<>();

        for(int i = 0;i<len;i++)
        {
            int src = connections[i][0];
            int dest = connections[i][1];

            outgoing.computeIfAbsent(src,k -> new ArrayList<>()).add(dest);
            incoming.computeIfAbsent(dest,k -> new ArrayList<>()).add(src);
        }

        // System.out.println(outgoing);
        // System.out.println(incoming);


        int[]ans = new int[1];
        int start = 0;

        dfsHelper(start,outgoing,incoming,ans,new HashSet<>());

        return ans[0];
        
    }
}