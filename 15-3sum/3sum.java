class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);


        for(int i = 0;i<n;i++)
        {

            if(i > 0 && nums[i] == nums[i-1])
            {
                continue;
            }
            int start = i+1;
            int end = n-1;

            // System.out.println(" Outer ");

            int target = -nums[i];

            while( start < end)
            {
                // System.out.println(" inner ");
                // while(start < n-1 && nums[start] == nums[start+1])
                // {
                //     System.out.println(" start ");
                //     start++;
                // }


                // while( end > 0 && nums[end] == nums[end-1])
                // {
                //     System.out.println(" end ");
                //     end--;
                // }

                // if(end >= start)
                // {
                //     break;
                // }

                int sum = nums[start] + nums[end];
                if(sum == target)
                {
                    List<Integer> miniAns = new ArrayList<>();
                    miniAns.add(nums[i]);
                    miniAns.add(nums[start]);
                    miniAns.add(nums[end]);
                    ans.add(miniAns);
                    start++;
                    end--;
                    // break;


                    while(start < end && nums[start] == nums[start-1])
                    {
                        // System.out.println(" start ");
                        start++;
                    }


                    while(start < end && nums[end] == nums[end+1])
                    {
                        // System.out.println(" end ");
                        end--;
                    }
                }

                else if(sum < target)
                {
                    start++;
                }else{
                    end--;
                }
            }
        }


        return ans;
        
    }
}









// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         Arrays.sort(nums);
//         int n = nums.length;

//         for (int i = 0; i < n; i++) {
//             // Skip duplicates for i
//             if (i > 0 && nums[i] == nums[i - 1]) continue;

//             int target = -nums[i];
//             int start = i + 1;
//             int end = n - 1;

//             while (start < end) {
//                 int sum = nums[start] + nums[end];

//                 if (sum == target) {
//                     ans.add(Arrays.asList(nums[i], nums[start], nums[end]));

//                     start++;
//                     end--;

//                     // Skip duplicates for start and end
//                     while (start < end && nums[start] == nums[start - 1]) start++;
//                     while (start < end && nums[end] == nums[end + 1]) end--;
//                 } else if (sum < target) {
//                     start++;
//                 } else {
//                     end--;
//                 }
//             }
//         }

//         return ans;
//     }
// }
