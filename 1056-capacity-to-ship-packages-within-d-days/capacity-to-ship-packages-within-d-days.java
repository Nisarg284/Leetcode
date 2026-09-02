class Solution {

    public static boolean valid(int cap,int[]arr,int days){

        int w = 0;


        for(int weight : arr){


            if(w + weight <= cap){
                w += weight;
            }else{
                days--;
                w = 0;
                w += weight;  
            }
        }

        return days > 0;
    }
    public int shipWithinDays(int[] weights, int days) {

        int totalWeight = 0;
        int minWeight = Integer.MIN_VALUE;
        for(int i : weights){
            totalWeight += i;
            minWeight = Math.max(i,minWeight);
        }

        int i = minWeight;
        int j = totalWeight;

        while(i <= j){
            int mid = (i + j) / 2;

            if(valid(mid,weights,days)){
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        return i;        
    }
}