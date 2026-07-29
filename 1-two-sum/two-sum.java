class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[]ans = {0,0};

        int n = nums.length;

        HashMap<Integer,Integer> hm = new HashMap<>();

        hm.put(nums[0],0);

        for(int i = 1;i<n;i++){

            int currEle = nums[i];

            if(hm.containsKey(target - currEle)){

                ans[0] = i;
                ans[1] = hm.get(target-currEle);
                return ans;
            }else{
                hm.put(currEle,i);
            }
        }

        return new int[2];
        
    }
}