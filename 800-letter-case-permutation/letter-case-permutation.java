class Solution {

    public static void helper(String str,int start,List<String> ans, int n)
    {
        if(start == n)
        {
            return;
        }

        for(int i = start;i<n;i++)
        {
            char curr = str.charAt(i);

            if(Character.isLetter(curr))
            {
                if(Character.isUpperCase(curr))
                {
                    char newChar = Character.toLowerCase(curr);
                    String newStr = str.substring(0,i) + newChar + str.substring(i+1);
                    ans.add(newStr);

                    // System.out.println(STR."Lower : \{newStr}");
                    helper(newStr,i+1,ans,n);
                }else{
                    char newChar = Character.toUpperCase(curr);
                    String newStr = str.substring(0,i) + newChar + str.substring(i+1);
                    ans.add(newStr);
                    // System.out.println(STR."Upper : \{newStr}");

                    helper(newStr,i+1,ans,n);
                }
            }
        }
    }

    public List<String> letterCasePermutation(String s) {


        int n = s.length();
        List<String> ans = new ArrayList<>();

        int idx = 0;

        helper(s,idx,ans,n);
        ans.add(s);

        return ans;
        
    }
}