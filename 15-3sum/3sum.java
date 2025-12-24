class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 0;i<n;i++)
        {
            int first = nums[i];

            if(i > 0 && nums[i] == nums[i-1])
            {
                continue;
            }

            int second = i+1;
            int third = n-1;

            while(second < third)
            {
                int sum = first + nums[second] + nums[third];

                if(sum == 0)
                {
                    ans.add(new ArrayList<>(List.of(first,nums[second],nums[third])));
                    second++;
                    third--;


                    while(second < third && nums[second] == nums[second-1])
                    {
                        second++;
                    }


                    while(second < third && nums[third] == nums[third+1])
                    {
                        third--;
                    }
                }else if(sum < 0)
                {
                    second++;
                }else{
                    third--;
                }
            }
        }

        return ans;
        
    }
}