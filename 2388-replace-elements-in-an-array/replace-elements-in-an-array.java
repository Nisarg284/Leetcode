class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = operations.length-1; i>=0; i--) {
            int key = operations[i][0];
            int val = operations[i][1];

            if (hm.containsKey(val)) {
                hm.put(key, hm.get(val));
            } else {
                hm.put(key, val);
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                nums[i] = hm.get(nums[i]);
            }

        }

        return nums;

    }
}