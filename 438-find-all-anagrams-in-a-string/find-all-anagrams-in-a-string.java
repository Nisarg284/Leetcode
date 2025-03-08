class Solution {
    public List<Integer> findAnagrams(String s, String p) {


        if(p.length() > s.length())
        {
            return new ArrayList<>();
        }
        
        // Define 2 HashMaps
        // 1st one stores p characters
        // 2nd ine stores a purticular window's charcaters.

        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();

        // put p string charcater in hm1 also store s1 k characters into hm2
        for(int i=0;i<p.length();i++)
        {
            char ch1 = p.charAt(i);
            char ch2 = s.charAt(i);

            hm1.put(ch1,hm1.getOrDefault(ch1,0)+1);
            hm2.put(ch2,hm2.getOrDefault(ch2,0)+1);
        }

        List<Integer> ans = new ArrayList<>();
        if(hm2.equals(hm1))
        {
            ans.add(0);
        }

        int i = 1;
        int j = p.length();



        while(j<s.length())
        {
            char ch1 = s.charAt(j);
            char ch2 = s.charAt(i-1);

            hm2.put(ch1,hm2.getOrDefault(ch1,0)+1);

            if(hm2.get(ch2) == 1)
            {
                hm2.remove(ch2);
            }else{
                hm2.put(ch2,hm2.get(ch2)-1);
            }

            if(hm2.equals(hm1))
            {
                ans.add(i);
            }

            i++;
            j++;

        }

        return ans;
    }
}