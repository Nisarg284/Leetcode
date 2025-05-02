class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();

        for(int i = 0;i<nums1.length;i++)
        {
            hs1.add(nums1[i]);
        }

        for(int i = 0;i<nums2.length;i++)
        {
            hs2.add(nums2[i]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al1 = new ArrayList<>();
        List<Integer> al2 = new ArrayList<>();

        for(int i = 0;i<nums1.length;i++)
        {
            if(!hs2.contains(nums1[i]))
            {
                al1.add(nums1[i]);
                hs2.add(nums1[i]);
            }
        }

         for(int i = 0;i<nums2.length;i++)
        {
            if(!hs1.contains(nums2[i]))
            {
                al2.add(nums2[i]);
                hs1.add(nums2[i]);
            }
        }

        ans.add(al1);
        ans.add(al2);

        return ans;




        
    }
}