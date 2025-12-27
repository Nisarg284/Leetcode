class Solution {

    public void helper(int idx,int[]arr,int target,List<Integer>subAns,List<List<Integer>> ans)
    {
        if(target < 0)
        {
            return;
        }

        if(target == 0)
        {
            ans.add(new ArrayList<>(subAns));
            return;
        }

        for(int i = idx;i<arr.length;i++)
        {
            subAns.add(arr[i]);
            helper(i,arr,target-arr[i],subAns,ans);
            subAns.removeLast();
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int currIdx = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>subAns = new ArrayList<>();



        helper(currIdx,candidates,target,subAns,ans);


        return ans;
        
    }
}