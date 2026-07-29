class Solution {
    public int majorityElement(int[] nums) {


        int ele = nums[0];
        int freq = 1;


        for(int i = 1;i<nums.length;i++){

            int curr = nums[i];
            if(freq == 0){
                ele = curr;
            }

            if(curr == ele){
                freq++;
            }else{
                freq--;
            }
        }

        return ele;
        
    }
}