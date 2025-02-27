class Solution {
    public int lenLongestFibSubseq(int[] arr) {

        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashMap<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            hm.put(arr[i], i);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = arr[i] - arr[j];
                if (diff < arr[j] && hm.containsKey(diff)) {
                    int k = hm.get(diff);
                    int length = dp.getOrDefault(k * n + j, 2) + 1;
                    dp.put(j * n + i, length);
                    maxLen = Math.max(maxLen, length);
                }
            }
        }

        if(maxLen < 2)
        {
            return 0;
        }

        return maxLen;
        
    }
}