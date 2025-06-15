class Solution {


    public static void swap(int[]arr,int curr,int idx)
    {
        int temp = arr[curr];
        arr[curr] = arr[idx];
        arr[idx] = temp;
    }


    public static void helper(int[] nums,int currIdx,int n,List<List<Integer>> ans,List<Integer> subAns )
    {
        if(subAns.size() == nums.length)
        {
            ans.add(new ArrayList<>(subAns));
            return;
        }

        for(int i = currIdx;i<n;i++)
        {
            subAns.add(nums[i]);

            swap(nums,i,currIdx);
            helper(nums, currIdx+1, n, ans, subAns);
            swap(nums,i,currIdx);
            subAns.removeLast();
        }
    }


    public List<List<Integer>> permute(int[] nums) {


        int n = nums.length;

        int currIdx = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subAns = new ArrayList<>();

        helper(nums,currIdx,n,ans,subAns);

        return ans;
    }
}