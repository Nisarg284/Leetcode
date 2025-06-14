class Solution {

    public static void helper(int k,int n,int start,int limit,List<List<Integer>> ans,List<Integer> subAns)
    {
        if(n<=0)
        {
            if(n == 0 && subAns.size() == k)
            {
                ans.add(new ArrayList<>(subAns));
            }
            return;
        }

        for(int i = start;i<=9;i++)
        {
            subAns.add(i);
            helper(k,n-i,i+1,limit,ans,subAns);
            subAns.removeLast();
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subAns = new ArrayList<>();

        helper(k,n,1,n,ans,subAns);

        return ans;
        
    }
}