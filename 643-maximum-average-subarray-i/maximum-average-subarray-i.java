class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;

        for(int i=0;i<k;i++)
        {
            sum +=nums[i];
        }

        int i=1;
        int j=k;

        double curr = sum;

        while(j < nums.length)
        {
            curr += nums[j]-nums[i-1];

            sum = Math.max(sum,curr);
            i++;
            j++;
        }

        return sum/k;
        
    }
}