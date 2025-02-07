class Solution {
    public int lengthOfLongestSubstring(String s) {

        // define 2 pointers
        int i = 0;
        int j = 0;

        // string length
        int n = s.length();

        // define Hashset
        HashSet<Character> hs = new HashSet<>();

        int ans = 0;

        while( i < n && j < n )
        {
            if(!hs.contains(s.charAt(j)))
            {
                hs.add(s.charAt(j));
                j++;
                ans = Math.max(ans,j-i);
            }
            else{
                hs.remove(s.charAt(i));
                i++;
            }
        }

        return ans;
        
    }
}