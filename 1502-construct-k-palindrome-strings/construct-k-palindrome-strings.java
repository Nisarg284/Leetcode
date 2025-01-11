class Solution {
    public boolean canConstruct(String s, int k) {

        if(k>s.length())
        {
            return false;
        }

        if(s.length() == k)
        {
            return true;
        }

        int count =0;

        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            
            hm.put(ch,hm.getOrDefault(ch,0)+1);

        }

        for(char ch :hm.keySet())
        {
            int co = hm.get(ch);
            if(co %2 == 1 )
            {
                count++;
            }

        
        }

        // if(count >=k)
        // {
        //     return true;
        // }


        return count<=k;
        
    }
}