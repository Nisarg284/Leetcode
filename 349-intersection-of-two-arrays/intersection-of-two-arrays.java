class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {


        Set<Integer> hs = new HashSet<>();

        for(int i : nums1){
            hs.add(i);
        }

        List<Integer> li = new ArrayList<>();

        for(int i : nums2){

            if(hs.contains(i)){
                li.add(i);
                hs.remove(i);
            }
        }

        int[] ans = new int[li.size()];

        for(int i = 0;i<ans.length;i++){
            ans[i] = li.get(i);
        }

        return ans;

        
        
    }
}