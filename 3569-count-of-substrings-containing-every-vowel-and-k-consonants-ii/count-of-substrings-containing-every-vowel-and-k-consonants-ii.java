// class Solution {
//     public long countOfSubstrings(String word, int k) {

//         HashMap<Character,Integer> hm = new HashMap<>();

//         long ans = 0;
//         int i = 0;
//         int j = 0;
//         int count = 0;

//         while(j<word.length())
//         {
//             char ch = word.charAt(j);
//             //  consonant case
//             if(ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u')
//             {
//                 count++;
//             }else{
//                 hm.put(ch,hm.getOrDefault(ch,0)+1);
//             }

//             while(i<j && count > k)
//             {
//                 char ch2 = word.charAt(i);
//                 if(ch2!='a' && ch2!='e' && ch2!='i' && ch2!='o'&& ch2!='u')
//                 {
//                     count--;
//                 }
//                 else{
//                     if(hm.get(ch2) == 1)
//                     {
//                         hm.remove(ch2);
//                     }else{
//                         hm.put(ch2,hm.getOrDefault(ch2,0)-1);
//                     }
//                 }
//                 i++;
//             }


//             if(hm.size() == 5 && count == k)
//             {
//                 ans++;
//             }
//             j++;

//         }
//         return ans;

//     }

// }


class Solution {
    public long countOfSubstrings(String word, int k) {
        return atLeastKConsonants(word, k) - atLeastKConsonants(word, k + 1);
    }
    
    private long atLeastKConsonants(String word, int k) {
        long ans = 0;
        int i = 0, j = 0;
        int consonantCount = 0;
        HashMap<Character, Integer> vowels = new HashMap<>();
        
        while (j < word.length()) {
            char ch = word.charAt(j);
            // Add to window
            if (isVowel(ch)) {
                vowels.put(ch, vowels.getOrDefault(ch, 0) + 1);
            } else {
                consonantCount++;
            }
            
            // Shrink window if consonants exceed k
            while (i <= j && consonantCount >= k && vowels.size() == 5) {
                // Count all substrings ending at j with at least k consonants
                ans += word.length() - j;
                
                // Shrink from left
                char left = word.charAt(i);
                if (isVowel(left)) {
                    vowels.put(left, vowels.get(left) - 1);
                    if (vowels.get(left) == 0) {
                        vowels.remove(left);
                    }
                } else {
                    consonantCount--;
                }
                i++;
            }
            j++;
        }
        
        return ans;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}