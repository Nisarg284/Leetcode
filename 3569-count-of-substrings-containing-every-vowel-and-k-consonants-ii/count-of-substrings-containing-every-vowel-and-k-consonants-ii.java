class Solution {

     public long countOfSubstrings(String word, int k) {
        return helper(word,k) - helper(word,k+1);
     }  

    public long helper(String word, int k) {

        HashMap<Character,Integer> hm = new HashMap<>();

        long ans = 0;
        int i = 0;
        int j = 0;
        int count = 0;

        while(j<word.length())
        {
            char ch = word.charAt(j);
            //  consonant case
            if(ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u')
            {
                count++;
            }else{
                hm.put(ch,hm.getOrDefault(ch,0)+1);
            }

            while(i<j && (count >= k && hm.size()==5) )
            {
                ans+=word.length() - j;
                char ch2 = word.charAt(i);
                if(ch2!='a' && ch2!='e' && ch2!='i' && ch2!='o'&& ch2!='u')
                {
                    count--;
                }
                else{
                    if(hm.get(ch2) == 1)
                    {
                        hm.remove(ch2);
                    }else{
                        hm.put(ch2,hm.get(ch2)-1);
                    }
                }
                i++;
            }

            if(hm.size() == 5 && count == k)
            {
                ans++;
            }
            j++;

        }
        return ans;

    }
}

