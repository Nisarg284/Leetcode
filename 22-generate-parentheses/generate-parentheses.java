class Solution {


    public static void helper(int opening,int closing,List<String>ans,int n,String str)
    {
        if(opening == 0 && closing == 0)
        {
            ans.add(str);
            return;
        }

        if(opening > 0)
        {
            helper(opening-1,closing,ans,n,str+'(');
            // return;
        }

        if(closing > opening)
        {
            helper(opening,closing-1,ans,n,str+')');
            // return;
        }

        // helper(opening-1,closing,ans,n,str+'(');
        // helper(opening,closing-1,ans,n,str+')');

    }
    public List<String> generateParenthesis(int n) {

        if(n == 0)
        {
            return new ArrayList<>();
        }

        int opening = n;
        int closing = n;

        List<String> ans = new ArrayList<>();

        helper(opening,closing,ans,n,"");

        return ans;

        
    }
}