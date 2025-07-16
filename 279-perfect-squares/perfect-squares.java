class Solution {
    public int numSquares(int n) {

        Queue<Integer> q = new LinkedList<>();

        Set<Integer> hs = new HashSet<>();
        hs.add(n);
        q.add(n);



        int level = 0;

        while(!q.isEmpty())
        {
            int size = q.size();


            for(int j = 0;j<size;j++)
            {
                n = q.remove();
                if( n == 0)
                {
                    return level;
                }
                for(int i = 1;i*i<=n;i++)
                {
                    int newEle = n-i*i;
                    if(!hs.contains(newEle))
                    {
                        q.add(newEle);
                        hs.add(newEle);
                    }
                    
                }
            }
            level++;
        }

        return level;
        
    }
}


