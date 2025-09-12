class Solution {


    public static void helper(int[]arr,int start,List<List<Integer>> ans,List<Integer> curr,int n)
    {
       ans.add(new ArrayList<>(curr));

       for(int i = start;i<n;i++)
       {
            curr.add(arr[i]);

            helper(arr,i+1,ans,curr,n);

            curr.removeLast();
       }
    }
    public List<List<Integer>> subsets(int[] nums) {


        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        helper(nums,0,ans,new ArrayList<>(),n);

        // System.out.println(ans);

        return ans;
        
    }
}