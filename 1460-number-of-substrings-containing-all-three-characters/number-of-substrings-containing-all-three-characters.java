class Solution {
    public int numberOfSubstrings(String s) {
        
        HashMap<Character,Integer> hm = new HashMap<>();

        int i=0;
        int j=0;

        int ans = 0;
        int n = s.length();

        while(j<n)
        {
            char ch = s.charAt(j);
            hm.put(ch,hm.getOrDefault(ch,0)+1);

            while(i<j && hm.size()>=3)
            {
                ans += n - j;
                char ch2 = s.charAt(i);

                if(hm.get(ch2) == 1)
                {
                    hm.remove(ch2);
                }else{
                    hm.put(ch2,hm.get(ch2)-1);
                }
                i++;
            }
            j++;
        }

        return ans;
        
    }
}