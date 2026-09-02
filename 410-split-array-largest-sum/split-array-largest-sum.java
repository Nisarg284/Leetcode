class Solution {

    public static boolean valid(int cap,int[]arr,int k){

        int sum = 0;

        for(int ele : arr){

            if(k <= 0){
                return false;
            }

            if(sum + ele <= cap){
                sum += ele;
            }else{
                k--;
                sum = 0;
                sum = ele;
            }
        }

        return k > 0;
    }
    public int splitArray(int[] nums, int k) {

        int i = Integer.MIN_VALUE;
        int j = 0;

        for(int num : nums){
            i = Math.max(i,num);
            j += num;
        }

        while(i <= j){

            int mid = (i+j) / 2;

            if(valid(mid,nums,k)){
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }

        return i;
        
    }
}