class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0;i<n-3;i++)
        {
            if(i > 0 && nums[i] == nums[i-1])
            {
                continue;
            }

            for(int j = i+1;j<n-2;j++)
            {
                if(j > i + 1 && nums[j] == nums[j-1])
                {
                    continue;
                }

                int start = j+1;
                int end = n-1;
                long search = (long)target - ((long)nums[i] + (long)nums[j]);
                // System.out.println(" search --> "+search);

                while( start < end)
                {
                    long currSum = (long)nums[start] + (long)nums[end];
                    // System.out.println(" currSum --> "+currSum);

                    if(currSum == search)
                    {
                        List<Integer> miniAns = new ArrayList<>();
                        miniAns.add(nums[i]);
                        miniAns.add(nums[j]);
                        miniAns.add(nums[start]);
                        miniAns.add(nums[end]);
                        ans.add(miniAns);
                        start++;
                        end--;

                        while(start < end && nums[start] == nums[start-1])
                        {
                            start++;
                        }
                        while(start < end && nums[end] == nums[end+1])
                        {
                            end--;
                        }
                    }else if(currSum < search)
                    {
                        start++;
                    }else{
                        end--;
                    }
                }
            }
        }
        return ans;  
    }
}