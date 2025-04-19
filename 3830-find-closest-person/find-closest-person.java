class Solution {
    public int findClosest(int x, int y, int z) {
        
        int xDist = Math.abs(x-z);
        int yDist = Math.abs(y-z);
        if(yDist == xDist)
        {
            return 0;
        }else if(yDist > xDist)
        {
            return 1;
        }else{
            return 2;
        }
        
    }
}