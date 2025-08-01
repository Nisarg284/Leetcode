class Solution {
    public int maxArea(int[] height) {

        int n = height.length;

        int start = 0;
        int end = n-1;

        int maxWater = 0;

        while(start < end)
        {

            System.out.println(" Run ");
            int currArea = end - start;
            int currWater = currArea * Math.min(height[start],height[end]);

            maxWater = Math.max(currWater,maxWater);

            if(height[start] <= height[end])
            {
                start++;
            }else{
                end--;
            }

        }

        return maxWater;
        
    }
}