class Solution {

   public static void helper(String str,int idx,List<String> ans,StringBuilder sb)
    {
        if(idx > str.length())
        {
            return;
        }


        if(sb.length() == str.length())
        {
            ans.add(sb.toString());
            return;
        }

        char ch = str.charAt(idx);
        sb.append(ch);
        helper(str, idx+1, ans, sb);
        sb.deleteCharAt(idx);


        if(Character.isLetter(ch))
        {
            char switchCh = Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch);

            sb.append(switchCh);
            helper(str, idx+1, ans, sb);
            sb.deleteCharAt(idx);
        }
    }

    
    public List<String> letterCasePermutation(String s) {

        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        helper(s,0,ans,sb);
        return ans;


    }
}