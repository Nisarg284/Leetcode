class Solution {
    public int maxArea(int[] height) {

        int i=0;
        int j = height.length-1;

        int maxWater=0;

        while(i < j)
        {
            // calculate current water
            int containsWater = Math.min(height[i],height[j]) * (j-i);

            maxWater = Math.max(maxWater,containsWater);

            // move i when height[i] < height[j]
            if(height[i] < height[j])
            {
                i++;
            }
            else{
                j--;
            }
        }

        return maxWater;


        
    }
}