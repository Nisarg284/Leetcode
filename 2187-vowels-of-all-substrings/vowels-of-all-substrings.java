class Solution {
    public long countVowels(String word) {

        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            {
                hs.add(i);
            }
        }

        long ans = 0;
        int n = word.length();

        for(int i:hs)
        {
            long count = (long)(i+1) * (long)(n-i);
            ans += count;

        }

        return ans;
        
        
    }
}