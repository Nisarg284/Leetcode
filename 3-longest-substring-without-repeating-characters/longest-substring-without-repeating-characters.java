class Solution {
    public int lengthOfLongestSubstring(String s) {
        

        int n = s.length();
        int i = 0;
        int j = 0;
        int ans = 0;

        Set<Character> hs = new HashSet<>();


        while(j < n){

            char curr = s.charAt(j);

            while(hs.contains(curr)){

                hs.remove(s.charAt(i));
                i++;
            }
            hs.add(curr);

            ans = Math.max(hs.size() , ans);
            j++;
        }

        return ans;

    }
}