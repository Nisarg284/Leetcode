class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {

        int srcRow =  startPos[0];
        int srcCol = startPos[1];

        int destRow = homePos[0];
        int destCol = homePos[1];


        int cost = 0;


        if(srcRow < destRow)
        {
            for(int i = srcRow+1;i<=destRow;i++)
            {
                cost += rowCosts[i];
            }
        }else{
            for(int i = srcRow-1;i>=destRow;i-- )
            {
                cost += rowCosts[i];
            }
        }


        if(srcCol < destCol)
        {
            for(int i = srcCol+1;i<=destCol;i++)
            {
                cost += colCosts[i];
            }
        }else{
            for(int i = srcCol-1;i>=destCol;i-- )
            {
                cost += colCosts[i];
            }
        }


        return cost;
        
    }
}