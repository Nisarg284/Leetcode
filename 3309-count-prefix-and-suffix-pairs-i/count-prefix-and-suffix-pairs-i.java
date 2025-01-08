class Solution {

    public static boolean helper(String str1,String str2)
    {
        if(str1 == str2)
        {
            return true;
        }

        if(str1.length() > str2.length())
        {
            return false;
        }

        
        // checking from forward direction
        for(int i=0;i<str1.length();i++)
        {
            if(str1.charAt(i) != str2.charAt(i))
            {
                return false;
            }
        }

        // checking from backward direction
        int idx = 0;
        for(int i=str2.length()-str1.length();i<str2.length();i++)
        {

            if(str2.charAt(i) != str1.charAt(idx))
            {
                return false;
            }
            idx++;
        }

        return true;
    }
    public int countPrefixSuffixPairs(String[] words) {

        int ans = 0;

        for(int i=0;i<words.length-1;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                String str1 = words[i];
                String str2 = words[j];
                if(helper(str1,str2))
                {
                    ans++;
                }
            }
        }
        return ans;
        
    }
}