class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {

        val set = mutableSetOf<Int>()
        

        for(i in nums)
        {
            if(set.contains(i))
            {
                return true
            }else{
                set.add(i)
            }
        }

        return false;
    }
}