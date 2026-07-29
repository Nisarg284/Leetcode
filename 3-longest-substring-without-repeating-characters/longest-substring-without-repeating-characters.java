class Solution {
    public int lengthOfLongestSubstring(String s) {


        int n = s.length();

        int i = 0;
        int j = 0;

        int ans = 0;

        HashSet<Character> hs = new HashSet<>();


        while(i < n && j < n){

            char curr = s.charAt(j);
            if(!hs.contains(curr)){
                hs.add(curr);
                j++;
                ans = Math.max(ans, j - i);
            }else{
                hs.remove(s.charAt(i));
                i++;
            }
        }

        return ans;
        
    }
}