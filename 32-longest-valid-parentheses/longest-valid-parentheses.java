class Solution {
    public int longestValidParentheses(String s) {

        int opening = 0;
        int closing = 0;
        int maxLen = 0;

        // left to right
        for(int i = 0;i<s.length();i++)
        {
            char curr = s.charAt(i);
            if(curr == '(')
            {
                opening++;
            }else{
                closing++;
            }

            if(opening == closing)
            {
                maxLen = Math.max(maxLen,opening+closing);
            }else if(closing > opening)
            {
                opening = closing = 0;
            }

        }



        opening = 0;
        closing = 0;


        // right to left
         for(int i = s.length()-1;i>=0;i--)
        {
            char curr = s.charAt(i);
            if(curr == '(')
            {
                opening++;
            }else{
                closing++;
            }

            if(opening == closing)
            {
                maxLen = Math.max(maxLen,opening+closing);
            }else if(closing < opening)
            {
                opening = closing = 0;
            }
        }

        return maxLen;
        
    }
}