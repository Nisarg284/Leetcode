class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        // find unique ids from both array so we decide ans array size
        Set<Integer> hs = new HashSet<>();

        for(int i=0;i<nums1.length;i++)
        {
            hs.add(nums1[i][0]);
        }
        
        for(int i=0;i<nums2.length;i++)
        {
            hs.add(nums2[i][0]);
        }

        int[][] ans = new int[hs.size()][2];

        int i=0;
        int j=0;
        int k=0;

        int n = nums1.length;
        int m = nums2.length;

        while(i<n && j<m)
        {
            if(nums1[i][0] < nums2[j][0])
            {
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1];
                i++;
            }else if(nums1[i][0] > nums2[j][0])
            {
                ans[k][0] = nums2[j][0];
                ans[k][1] = nums2[j][1];
                j++;
            }else{
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            }
            k++;
        }

        while(i<n)
        {
            ans[k][0] = nums1[i][0];
            ans[k][1] = nums1[i][1];
            i++;
            k++;
        }

         while(j<m)
        {
            ans[k][0] = nums2[j][0];
            ans[k][1] = nums2[j][1];
            j++;
            k++;
        }


        return ans;



    }
}