class Solution {


    public static boolean isPalindrome(String str)
    {
        int i = 0;
        int j = str.length()-1;

        while( i < j)
        {
            if(str.charAt(i) != str.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }


    public static void helper(String str,int start,List<List<String>> ans,List<String>curr,int n)
    {
        if(start == n)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start;i<n;i++)
        {
            String s = str.substring(start,i+1);

            if(isPalindrome(s))
            {
                curr.add(s);

                helper(str,i+1,ans,curr,n);

                curr.removeLast();
            }

        }
    }

    
    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        int n = s.length();
        StringBuilder sb = new StringBuilder();

        int idx = 0;

        helper(s,idx,ans,new ArrayList<>(),n);


        return ans;
        
    }
}