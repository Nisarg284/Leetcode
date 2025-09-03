class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {

        int n = edges.length;
        int[] parent = new int[n+1];
        int[] candidate1 = new int[2];
        int[] candidate2 = new int[2];
        for(int[] edge : edges)
        {
            int src = edge[0];
            int dest = edge[1];

            if(parent[dest]!= 0)
            {
                // candidate2 = new int[]{src,dest};
                candidate2[0] = src;
                candidate2[1] = dest;
                // candidate1 = new int[]{parent[dest],dest};
                candidate1[0] = parent[dest];
                candidate1[1] = dest;
            }else{
                parent[dest] = src;
            }
        }

        // System.out.println("candidate1-> src :  "+candidate1[0]+" , dest : "+candidate1[1]);
        // System.out.println("candidate2-> src :  "+candidate2[0]+" , dest : "+candidate2[1]);

        boolean flag = candidate1[0] == 0;
        DSU set = new DSU(n);

        for(int[] edge : edges)
        {
            int src = edge[0];
            int dest = edge[1];
            // case 1: simple cycle detection
            if(flag)
            {
                if(set.union(src,dest))
                {
                    return new int[]{src,dest};
                }
            }else{
                if(src == candidate2[0] && dest == candidate2[1])
                {
                    continue;
                }

                if(set.union(src,dest))
                {
                    return candidate1;
                }

            }
        }

        return candidate2;
    

    }
}


class DSU{
    private int[] parent;
    private int[] size;

    public DSU(int n)
    {
        parent = new int[n+1];
        size = new int[n+1];
        Arrays.fill(size,1);

        for(int i = 1;i<=n;i++)
        {
            parent[i] = i;
        }
    }


    // find
    public int find(int i){
        if(parent[i] == i)
        {
            return i;
        }

        parent[i] = find(parent[i]);

        return parent[i];
    }

    // union
    public boolean union(int i,int j)
    {
        int parentOfi = find(i);
        int parentOfj = find(j);

        if(parentOfi == parentOfj)
        {
            // cycle detected
            return true;
        }

        int sizeOfi = size[parentOfi];
        int sizeOfj = size[parentOfj];

        if(sizeOfi >= sizeOfj)
        {
            size[parentOfi] += sizeOfj;
            parent[parentOfj] = parentOfi;
        }else{
            size[parentOfj] += sizeOfi;
            parent[parentOfi] = parentOfj;
        }

        return false;
    }


}