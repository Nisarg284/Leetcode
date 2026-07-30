class Solution {
    public int maxFrequencyElements(int[] nums) {


        int n = nums.length;
        int maxFreq = 0;

        Map<Integer,Integer> hm = new HashMap<>();

        for(int i = 0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            maxFreq = Math.max(hm.get(nums[i]),maxFreq);   
        }

        int count = 0;
        for(Integer key : hm.keySet()){
            if(hm.get(key) == maxFreq){
                count+=maxFreq;
            }
        }

        return count;
        
    }
}