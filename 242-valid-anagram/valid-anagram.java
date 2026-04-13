class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
        {
            return false;
        }


        Map<Character,Integer> hm = new HashMap<>();

        for(int i = 0;i<s.length();i++)
        {
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }


        for(int i = 0;i<t.length();i++)
        {
            char curr = t.charAt(i);
            if(!hm.containsKey(curr))
            {
                return false;
            }

            if(hm.get(curr) == 1)
            {
                hm.remove(curr);
            }else{
                hm.put(curr,hm.get(curr)-1);
            }
        }

        return hm.isEmpty();
        
    }
}