class Solution {

    public static void helper(String str,int start,int end,int[] globalStart,int[] maxLength){
        while(start>=0 && end < str.length() && str.charAt(start) == str.charAt(end)){
            start--;
            end++;
        }

        int currLength = end - start - 1;

        if(currLength > maxLength[0]){
            maxLength[0] = currLength;
            globalStart[0] = start + 1;
        }
    }

    public String longestPalindrome(String s) {

        if(s.length() == 0 || s == null){
            return "";
        }

        int n = s.length();
        int[] globalStart = {0};
        int[] maxLength = {0};

        for(int i = 0;i<n;i++){
            int start = i;
            int end = i;

            // odd length
            helper(s,start,end,globalStart,maxLength);

            // even length
            helper(s,start,end+1,globalStart,maxLength);
        }

        return s.substring(globalStart[0],globalStart[0] + maxLength[0]);
        
    }


}