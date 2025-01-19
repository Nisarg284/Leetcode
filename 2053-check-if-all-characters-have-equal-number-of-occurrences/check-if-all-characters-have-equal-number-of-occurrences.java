class Solution {
    public boolean areOccurrencesEqual(String s) {

        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }

        int count = hm.get(s.charAt(0));

        for(Character ch:hm.keySet())
        {
            if(hm.get(ch) != count)
            {
                return false;
            }
        }

        return true;
        
    }
}