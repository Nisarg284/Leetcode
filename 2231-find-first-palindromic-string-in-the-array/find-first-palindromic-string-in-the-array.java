class Solution {

    public static boolean isPalindrome(String s)
    {
        int n = s.length();

        int start = 0;
        int end = n-1;

        while(start<=end)
        {
            char st = s.charAt(start);
            char en = s.charAt(end);
            if(st != en)
            {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
    public String firstPalindrome(String[] words) {

        int n = words.length;
        for(int i = 0;i<n;i++)
        {
            if(isPalindrome(words[i]))
            {
                return words[i];
            }
        }

        return "";
        
    }
}