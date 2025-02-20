class Solution {

    public static void helper(int[] candidates, int target,List<Integer> miniAns,List<List<Integer>> ans,int idx)
    {
        // base case:
        if(target == 0)
        {
            List<Integer> temp = new ArrayList<>(miniAns);

            ans.add(temp);
            return;
        }

        if(target <=-1)
        {
            return;
        }

        for(int i=idx;i<candidates.length;i++)
        {
            if(target - candidates[i] >= 0 )
            {
                miniAns.add(candidates[i]);
                helper(candidates,target-candidates[i],miniAns,ans,i);
                miniAns.removeLast();
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> miniAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int idx = 0;

        helper(candidates,target,miniAns,ans,idx);

        return ans;
        
    }
}