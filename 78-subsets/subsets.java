class Solution {
    public static void helper(int[] nums, int i, List<Integer> ans, List<List<Integer>> finalAns) {
        if (i == nums.length) {
            finalAns.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[i]);
        helper(nums, i + 1, ans, finalAns);
        ans.remove(ans.size()-1);
        
        helper(nums, i + 1, ans, finalAns);

    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> finalAns = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        int i = 0;
        helper(nums, i, ans, finalAns);

        // finalAns.add(ans);

        return finalAns;
    }
}