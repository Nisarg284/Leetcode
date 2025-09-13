class Solution {

    public static void helper(int[]arr,int start,int target,List<List<Integer>> ans,List<Integer> curr,int n)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0)
        {
            return;
        }

        for(int i = start;i<n;i++)
        {
            if( i != start && arr[i] == arr[i-1])
            {
                continue;
            }

            curr.add(arr[i]);
            helper(arr,i+1,target - arr[i],ans,curr,n);
            curr.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);
        int n = candidates.length;

        helper(candidates,0,target,ans,new ArrayList<>(),n);

        return ans;
        
    }
}