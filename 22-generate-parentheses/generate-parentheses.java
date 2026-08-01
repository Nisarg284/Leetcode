class Solution {


    public static void helper(int opening,int closing,String curr,List<String>ans){

        if(opening == 0 && closing == 0){

            ans.add(curr);
            return;
        }

        if(opening > 0){
            helper(opening-1,closing,curr + '(',ans);
        }

        if(closing > opening){
            helper(opening,closing - 1,curr + ')',ans);
        }
    }

    public List<String> generateParenthesis(int n) {

        // StringBuilder sb = new StirngBuilder();

        List<String> ans = new ArrayList<>();


        helper(n,n,"",ans);

        return ans;
        
    }
}