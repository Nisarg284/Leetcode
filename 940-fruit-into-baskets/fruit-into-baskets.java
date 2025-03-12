class Solution {
    public int totalFruit(int[] fruits) {

        HashMap<Integer,Integer> hm = new HashMap<>();

        int i = 0;
        int j = 0;
        int n = fruits.length;
        int k = 2;
        int ans = 0;


        while(j<n)
        {
            hm.put(fruits[j],hm.getOrDefault(fruits[j],0)+1);

            while(hm.size() > k)
            {
                int right = fruits[i];

                if(hm.get(right) == 1)
                {
                    hm.remove(right);
                }else{
                    hm.put(right,hm.get(right)-1);
                }
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }


        // int ans = 0;
        // for(int a:hm.keySet())
        // {
        //     ans+=hm.get(a);
        // }

        return ans;

        
    }
}