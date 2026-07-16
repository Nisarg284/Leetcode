class Solution {

    public static int gcdFinder(int a,int b){
        return b == 0 ? a : gcdFinder(b,a%b);
    }


    public long gcdSum(int[] nums) {

        int n = nums.length;
        int[] prefixGcd = new int[n];

        int currMax = nums[0];

        for(int i = 0;i<n;i++){

            currMax = Math.max(currMax,nums[i]);

            prefixGcd[i] = gcdFinder(nums[i],currMax);
            // System.out.print(prefixGcd[i]+" ");
        }

        Arrays.sort(prefixGcd);

        for(int i : prefixGcd){
            System.out.print(i+" ");
        }

        int low = 0;
        int high = n-1;

        long gcdSum = 0;

        while(low < high){

            gcdSum += gcdFinder(prefixGcd[low],prefixGcd[high]);
            low++;
            high--;
        }

        return gcdSum;        
    }
}