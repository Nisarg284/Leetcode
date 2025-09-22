class Solution {
    public int maxFrequencyElements(int[] nums) {

        int maxFreq = 0;
        // Set<Integer> hs = new HashSet<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        

        for(int i : nums)
        {
            hm.put(i,hm.getOrDefault(i,0)+1);
            maxFreq = Math.max(hm.get(i),maxFreq);
        }

        int maxFreqCount = 0;

        for(int key : hm.keySet())
        {
            if(hm.get(key) == maxFreq)
            {
                maxFreqCount += hm.get(key);
            }
        }

        return maxFreqCount;


        
    }
}