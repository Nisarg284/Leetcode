class Solution {
    public boolean containsDuplicate(int[] nums) {


        Set<Integer> hs = new HashSet<>();

        for(int num : nums)
        {
            if(!hs.contains(num))
            {
                hs.add(num);
            }else{
                return true;
            }
        }

        return false;
        
    }
}