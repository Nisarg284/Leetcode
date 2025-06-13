class Solution {

    public static void helper(int n,int k,int idx,List<List<Integer>> ans,List<Integer> subAns)
    {
        if(subAns.size() == k)
        {
            ans.add(new ArrayList<>(subAns));
            return;
        }

        for(int i = idx;i<=n;i++) {

            subAns.add(i);
            helper(n, k, i + 1, ans, subAns);
            subAns.removeLast();
        }
    }
    public List<List<Integer>> combine(int n, int k) {

        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subAns = new ArrayList<>();


        int idx = 1;

//        for(int i = 1;i<=n;i++)
//        {
            helper(n,k,idx,ans,subAns);
//        }


        return ans;
    }
}