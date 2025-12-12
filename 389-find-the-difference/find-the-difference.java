class Solution {
    public char findTheDifference(String s, String t) {

        Map<Character,Integer> hm = new HashMap<>();

        for(int i = 0;i<t.length();i++)
        {
            hm.put(t.charAt(i),hm.getOrDefault(t.charAt(i),0)+1);
        }

        for(int i = 0;i<s.length();i++)
        {
            char curr = s.charAt(i);
            if(!hm.containsKey(curr))
            {
                return curr;
            }

            if(hm.get(curr) == 1)
            {
                hm.remove(curr);
            }else{
                hm.put(curr,hm.get(curr)-1);
            }
        }

        for(Character ch : hm.keySet())
        {
            return ch;
        }

        return ' ';
        
    }
}