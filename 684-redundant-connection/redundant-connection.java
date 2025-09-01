class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        HashSet<Integer> hs = new HashSet<>();

        for(int[] edge : edges)
        {
            int src = edge[0];
            int dest = edge[1];

            hs.add(src);
            hs.add(dest);
        }

        int n = hs.size();

        DSU set = new DSU(n);
        int[] ans = new int[2];

        for(int[] edge: edges)
        {
            int src = edge[0];
            int dest = edge[1];

            if(set.union(src,dest))
            {
                ans[0] = src;
                ans[1] = dest;
                break;
            }
        }

        return ans;
        
    }
}

class DSU{
    private int[] parent;
    private int[] size;

    public DSU(int n){
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