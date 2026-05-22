class Solution {
    public int findJudge(int n, int[][] trust) {

        int[]inDegree = new int[n+1];

        for(int[]arr : trust){

            int src = arr[0];
            int dest = arr[1];
            inDegree[src]--;
            inDegree[dest]++;
        }

        System.out.println();


        for(int i = 1;i<=n;i++){
            if(inDegree[i] == n-1){
                return i;
            }
        }

        return -1;
        
    }
}