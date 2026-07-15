class Solution {
    public boolean isPerfectSquare(int num) {

        long low = 1;

        long high = (long)(num / 2)+1;

        while(low <= high){

            if(low * low == num){
                return true;
            }

            low++;
        }

        return false;
        
    }
}