class Solution {
    public int totalFruit(int[] fruits) {

        HashMap<Integer,Integer> hm = new HashMap<>();

        int i = 0;
        int j = 0;
        int n = fruits.length;
        int k = 2;
        int ans = 1;


        while(j<n)
        {
            hm.put(fruits[j],hm.getOrDefault(fruits[j],0)+1);
            while(hm.size() > k)
            {
                int left = fruits[i];

                if(hm.get(left) == 1)
                {
                    hm.remove(left);
                }else{
                    hm.put(left,hm.get(left)-1);
                }
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}