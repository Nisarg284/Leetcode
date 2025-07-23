class Solution {

    public static boolean isVowel(char ch)
    {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o'  || ch == 'u';
    }
    public int maxVowels(String s, int k) {

        int vowel = 0;
        int j = 0;
        

        for(j = 0;j<k;j++)
        {
            char ch = s.charAt(j);
            if(isVowel(ch))
            {
                vowel++;
            }
        }

        int i = 1;

        int max = vowel;

        while(j<s.length())
        {
            // int currCount = vowel;
            char curr = s.charAt(j);
            char prev = s.charAt(i-1);
            if(isVowel(curr))
            {
                vowel++;
            }

            if(isVowel(prev))
            {
                vowel--;
            }

            max = Math.max(max,vowel);
            i++;
            j++;
        }

        return max;
        
    }
}