class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        

        int totalCost = 0;
        int totalGas = 0;
        int n = gas.length;

        for(int i = 0;i<n;i++){
            totalCost += cost[i];
            totalGas += gas[i];
        }

        if(totalGas < totalCost){
            return -1;
        }

        int currGas = 0;
        int start = 0;

        for(int i = 0;i<n;i++){
            currGas += gas[i];
            currGas -= cost[i];

            if(currGas < 0){
                currGas = 0;
                start = i+1;
            }
        }

        return start;
    }
}