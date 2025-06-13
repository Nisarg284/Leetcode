class Solution {

    public static void helper(int[] arr, int target,List<List<Integer>> ans,List<Integer> subAns,int idx)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(subAns));
            return;
        }

        if(target < 0)
        {
            return;
        }

        for(int i = idx;i<arr.length;i++)
        {
            // if(target > 0)
            // {

                subAns.add(arr[i]);
                // target-=arr[i];
                helper(arr,target-arr[i],ans,subAns,i);
                subAns.removeLast();
                // target+=arr[i];
            // }

        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> subAns = new ArrayList<>();

        helper(candidates,target,ans,subAns,0);

        return ans;
        
    }
}