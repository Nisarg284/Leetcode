class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2))
        {
            return true;
        }

        if(s1.length() != s2.length())
        {
            return false;
        }

        int count = 0;

        int first = -1;
        int second = -1;

        for(int i=0;i<s1.length();i++)
        {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            
            if(count > 2)
            {
                return false;
            }


            if(ch1 != ch2)
            {
                count++;            

                if(count == 1)
                {
                    first = i;
                }else if(count == 2)
                {
                    second = i;
                }
            }
        }

        return (count == 2) && (s1.charAt(first) == s2.charAt(second)) && (s1.charAt(second) == s2.charAt(first));
        
    }
}