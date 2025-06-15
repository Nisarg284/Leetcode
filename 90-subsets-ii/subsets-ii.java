class Solution {

     public static void helper(int[]nums,int idx,List<List<Integer>>ans,List<Integer> subAns)
    {
        ans.add(new ArrayList<>(subAns));

        for(int i = idx;i<nums.length;i++)
        {
            // System.out.print(nums[i] +" ");
           
            if(i > idx && nums[i] == nums[i-1])
            {
                continue;
            }
            subAns.add(nums[i]);
            helper(nums, i+1, ans, subAns);

            
            subAns.removeLast();
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        if(nums.length == 0)
        {
            return new ArrayList<>();
        }


        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subAns = new ArrayList<>();

        helper(nums,0,ans,subAns);

//        ans.add(new ArrayList<>());

        return ans;
        
    }
}