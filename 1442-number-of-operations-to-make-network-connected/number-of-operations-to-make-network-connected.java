class Solution {
    public int makeConnected(int n, int[][] edges) {
        if(n-1 > edges.length)
        {
            return -1;
        }

        DSU set = new DSU(n);

        for(int[] edge : edges)
        {
            int src = edge[0];
            int dest = edge[1];

            set.union(src,dest);
        }

        int count = 0;

        // int[] parent = set.getParent();
        // int[] size = set.getSize(); 

        for(int i = 0;i<n;i++)
        {
            if(set.find(i) == i)
            {
                count++;
            }
        }

        return count-1;  
    }
}


class DSU{

    private int[] parent;
    private int[] size;

    public DSU(int n)
    {
        parent = new int[n];
        size = new int[n];
        Arrays.fill(size,1);
        for(int i = 0;i<n;i++)
        {
            parent[i] = i;
        }
    }

    // find
    public int find(int i)
    {
        if(parent[i] == i)
        {
            return i;
        }

        return parent[i] = find(parent[i]);
    }

    // union
    public void union(int i,int j)
    {
        int parentOfi = find(i);
        int parentOfj = find(j);

        if(parentOfi != parentOfj)
        {
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
        }
    }
}