class Solution {
    public int characterReplacement(String s, int k) {

        int i = 0;
        int j = 0;

        int maxLen = 0;
        // char ch = s.charAt(0);
        int maxFreq = 0;
        int n = s.length();

        HashMap<Character, Integer> hm = new HashMap<>();

        while(j<n)
        {
            char curr = s.charAt(j);
            hm.put(curr,hm.getOrDefault(curr,0)+1);

            maxFreq = Math.max(maxFreq,hm.get(curr));

            while(j-i+1 - maxFreq > k)
            {
                hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
                i++;
            }

            maxLen = Math.max(maxLen,j-i+1);
            j++;
            // char curr = s.charAt(j);
            // if(curr == ch)
            // {
            //     j++;
            // }else{
            //     if(flips < k)
            //     {
            //         j++;
            //         flips++;
            //     }else{
            //         maxLen = Math.max(maxLen,j-i);
            //         while(s.charAt(i) == ch)
            //         {
            //             i++;
            //         }
            //         i++;
            //         j++;
            //     }
            // }
        }

        // maxLen = Math.max(maxLen,j-i);

        return maxLen;
        
    }
}