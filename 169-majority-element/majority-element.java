class Solution {
    public int majorityElement(int[] nums) {

        int max = 0;

        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i : nums)
        {
            hm.put(i,hm.getOrDefault(i,0)+1);
        }

        System.out.println(hm);

        for(int ele : hm.keySet())
        {
            if(hm.get(ele) > nums.length /2)
            {
                max = ele;
                return max;
            }
        }

        return 1;
        
    }
}