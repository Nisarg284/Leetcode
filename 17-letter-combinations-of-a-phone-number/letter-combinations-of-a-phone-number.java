class Solution {


    public static void helper(String digits,int idx,List<String> ans,HashMap<Character,List<Character>> hm,StringBuilder sb,int n)
    {
        if(sb.length() == digits.length())
        {
            ans.add(sb.toString());
            return;
        }

        for(int i = idx;i<n;i++)
        {
            char curr = digits.charAt(i);
            // List<C hm.get(curr);
            for(Character ch : hm.get(curr))
            {
                sb.append(ch);
                helper(digits,i+1,ans,hm,sb,n);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0)
        {
            return new ArrayList<>();
        }
        HashMap<Character,List<Character>> hm = new HashMap<>();

        hm.put('2',Arrays.asList('a','b','c'));
        hm.put('3',Arrays.asList('d','e','f'));
        hm.put('4',Arrays.asList('g','h','i'));
        hm.put('5',Arrays.asList('j','k','l'));
        hm.put('6',Arrays.asList('m','n','o'));
        hm.put('7',Arrays.asList('p','q','r','s'));
        hm.put('8',Arrays.asList('t','u','v'));
        hm.put('9',Arrays.asList('w','x','y','z'));


        List<String> ans = new ArrayList<>();
        int idx = 0;
        int n = digits.length();

        helper(digits,idx,ans,hm,new StringBuilder(),n);

        return ans;



        
    }
}