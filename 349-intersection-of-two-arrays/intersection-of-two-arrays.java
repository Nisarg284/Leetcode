class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0;i<nums1.length;i++)
        {
            hs.add(nums1[i]);
        }

        ArrayList<Integer> al = new ArrayList<>();

        for(int i = 0;i<nums2.length;i++)
        {
            if(hs.contains(nums2[i]))
            {
                al.add(nums2[i]);
                hs.remove(nums2[i]);
            }
        }

        int[]ans = new int[al.size()];
        int j = 0;
        for(int i:al)
        {
            ans[j++] = i;
        }

        return ans;
        
    }
}