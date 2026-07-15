class Solution {
    public boolean judgeSquareSum(int c) {

        long low = 0;
        long high = (long)(Math.sqrt(c));

        long sum;

        while(low <= high){
            sum = (long)(Math.pow(low,2) + Math.pow(high,2));
            System.out.println("Sum ----> "+ sum);

            if(sum == c){
                return true;
            }else if(sum < c){
                low++;
            }else{
                high--;
            }
        }

        return false;
        
    }
}