class Solution {


    public static int helper(int idx,int target,int[]arr){
        if(idx < 0 && target == 0){
            return 1;
        }

        if(idx < 0 ){
            return 0;
        }

        int add = helper(idx - 1,target + arr[idx],arr);
        int minus = helper(idx - 1,target - arr[idx],arr);


        return add + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;

        return helper(n-1,target,nums);
        
    }
}