class Solution {

    public static void helper(int[]nums,List<List<Integer>> ans,boolean[] vis,List<Integer> curr,int n)
    {
        if(curr.size() == n)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0;i<n;i++)
        {
            if(vis[i])
            {
                continue;
            }

            
            if(i > 0 && nums[i] == nums[i-1] && !vis[i-1])
            {
                continue;
            }

            curr.add(nums[i]);
            vis[i] = true;
            helper(nums,ans,vis,curr,n);
            vis[i] = false;
            curr.removeLast();
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {


        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        helper(nums,ans,new boolean[n],new ArrayList<>(),n);

        return ans;
        
    }
}