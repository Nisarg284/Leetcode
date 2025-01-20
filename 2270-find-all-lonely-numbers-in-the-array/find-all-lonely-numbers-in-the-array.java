class Solution {
    public List<Integer> findLonely(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for (int i : hm.keySet()) {
            int po = i + 1;
            int back = i - 1;

            if (hm.get(i) < 2) {
                if (!hm.containsKey(po) && !hm.containsKey(back)) {
                    ans.add(i);
                }
            }

        }

        return ans;

    }
}