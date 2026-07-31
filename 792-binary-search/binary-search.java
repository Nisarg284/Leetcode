class Solution {
    public int search(int[] nums, int target) {

        int n = nums.length;
        int i = 0;
        int j = n-1;

        while(i <= j){

            int mid =  (i + j)/ 2;
            if(nums[mid] == target){
                return mid;
            }

            if(target > nums[mid]){
                i = mid+1;
            }else{
                j = mid-1;
            }
        }

        return -1;
        
    }
}