class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;

        int minProd = nums[0];
        int currMinProd;


        int maxProd = nums[0];
        int currMaxProd;

        int ans = nums[0];


        for(int i = 1;i<n;i++)
        {
            int curr = nums[i];


            currMinProd = Math.min(curr * maxProd,curr * minProd);
            currMaxProd = Math.max(curr * maxProd,curr * minProd);


            minProd = Math.min(curr,currMinProd);
            maxProd = Math.max(curr,currMaxProd);

            ans = Math.max(ans,maxProd);
        }
        

        return ans;

    }
}