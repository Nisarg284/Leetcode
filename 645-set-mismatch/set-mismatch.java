class Solution {
    public int[] findErrorNums(int[] nums) {
        

         int n = nums.length;
        int freq[] = new int[n+1];
        for(int i = 0 ; i<n ; i++){
            freq[nums[i]]++;
        }
        int [] ans = new int[2];
        for(int i = 1 ; i<n+1; i++){
            if(freq[i]==2)  ans[0] = i;
            if(freq[i]==0)  ans[1] = i;
        }
        return ans;
    }
}