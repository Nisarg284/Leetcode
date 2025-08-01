class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;

        int ans = nums[0];

        int maxProd = nums[0];
        int currMaxProd;

        int minProd = nums[0];
        int currMinProd;


        for(int i = 1;i<n;i++)
        {
            int curr = nums[i];


            currMinProd = Math.min(curr * minProd , curr * maxProd);
            currMaxProd = Math.max(curr * maxProd , curr * minProd);


            minProd = Math.min(curr,currMinProd);
            maxProd = Math.max(curr,currMaxProd);

            ans = Math.max(ans,maxProd);

        }

        // int ans = Math.max(maxProd * minProd,Math.max(maxProd,minProd));

        return ans;
        
    }
}