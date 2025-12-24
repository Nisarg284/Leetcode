class Solution {
    public int[] productExceptSelf(int[] nums) {

        int zeroIdx = -1;
        int zeroCount = 0;
        int prefixProd = 1;
        int withoutZeroProd = 1;

        int n = nums.length;
        for(int i = 0;i<n;i++)
        {
            if(nums[i] == 0)
            {
                if(zeroCount >= 1)
                {
                    return new int[n];
                }else
                {
                    zeroCount++;
                    zeroIdx = i;
                    withoutZeroProd = prefixProd;
                    prefixProd = 0;
                }
            }else{
                withoutZeroProd *= nums[i];
                prefixProd *= nums[i];

            }
        }

        int[]ans = new int[n];

        for(int i = 0;i<n;i++)
        {
            if(i == zeroIdx)
            {
                ans[i] = withoutZeroProd;
            }else if(zeroCount < 1)
            {
                ans[i] = prefixProd / nums[i];
            }
        }

        System.out.println("zeroCount : "+zeroCount);
        System.out.println("zeroIdx : "+zeroIdx);
        System.out.println("withoutZeroProd : "+withoutZeroProd);
        System.out.println("prefixProd : "+prefixProd);

        return ans;
        
    }
}