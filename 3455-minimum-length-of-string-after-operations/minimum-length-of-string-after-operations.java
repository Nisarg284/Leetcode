class Solution {
        public static int minimumLength(String str)
    {
        if(str.length() <=2)
        {
            return str.length();
        }

        HashMap<Character,Integer> hm = new HashMap<>();
        int count = 0;

        // count frequency
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }

        // iterate in hashmap
        for(char ch : hm.keySet())
        {
            int freq = hm.get(ch);

            if(freq > 2)
            {
                // Even case:
                if(freq%2 == 0)
                {
                    count += ((freq/2)-1)*2;
                }else {
                    count += (freq/2)*2;
                }
            }
        }
        return str.length()-count;

    }
}