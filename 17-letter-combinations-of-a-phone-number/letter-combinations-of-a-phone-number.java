class Solution {

    public static void helper(String digits,HashMap<Character,String>hm,int iter,StringBuilder sb,List<String>ans)
    {
        if(iter == digits.length())
        {
            return;
        }

        String s = hm.get(digits.charAt(iter));

        for(int i = 0;i<s.length();i++)
        {
            sb.append(s.charAt(i));
            helper(digits,hm,iter+1,sb,ans);

            if(sb.length() == digits.length())
            {
                ans.add(sb.toString());
            }

            sb.deleteCharAt(iter);
        }
    }
    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0)
        {
            return new ArrayList<>();
        }
        
        HashMap<Character,String> hm = new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");

        List<String> ans = new ArrayList<>();

        int iter  = 0;

        helper(digits,hm,iter,new StringBuilder(),ans);

        return ans;






    }
}