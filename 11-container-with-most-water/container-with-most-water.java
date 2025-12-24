class Solution {
    public int maxArea(int[] height) {

        
        int n = height.length;
        int left = 0;
        int right = n-1;

        int maxWater = 0;


        while(left < right)
        {
            int area = right - left;
            int currWater = area * Math.min(height[left],height[right]);

            maxWater = Math.max(currWater,maxWater);

            if(height[left] <= height[right])
            {
                left++;
            }else{
                right--;
            }
        }

        return maxWater;
        
    }
}