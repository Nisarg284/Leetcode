class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int i = 0;
        int j = n-1;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int trappedWater = 0;

        while(i<j)
        {
            leftMax = Math.max(height[i],leftMax);
            rightMax = Math.max(height[j],rightMax);


            if(leftMax < rightMax)
            {
                trappedWater += leftMax - height[i];
                i++;
            }else{
                trappedWater += rightMax - height[j];
                j--;
            }
        }

        return trappedWater;

        
    }
}