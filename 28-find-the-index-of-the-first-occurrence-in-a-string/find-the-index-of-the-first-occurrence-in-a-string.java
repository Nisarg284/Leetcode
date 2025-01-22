class Solution {
    public int strStr(String s1, String s2) {

        if(s1.length() < s2.length())
        {
            return -1;
        }

        int i=0;
        int j=s2.length()-1;

        char first = s2.charAt(i);
        char second = s2.charAt(j);

        while(j<s1.length())
        {
            char ch1 = s1.charAt(i);
            char ch2 = s1.charAt(j);
            if(ch1 == first && ch2 == second)
            {
                int a = i;
                int b=j;
                boolean flag = true;
                for(int k=0;k<s2.length();k++)
                {
                    if(s1.charAt(a)!=s2.charAt(k))
                    {
                        flag = false;
                        break;
                    }
                    a++;
                }

                if(flag == true)
                {
                    return i;
                }
            }
            i++;
            j++;
        }

        return -1;
        
    }
}