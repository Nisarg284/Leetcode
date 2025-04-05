// class Solution {
//     public String reverseVowels(String s) {

//         StringBuilder sb = new StringBuilder();

//         ArrayList<Character> arr = new ArrayList<>();

//         for(int i = 0;i<s.length();i++)
//         {
//             char ch = s.charAt(i);
//             if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'U' ||
//                 ch == 'A' ||ch == 'E' ||ch == 'I' ||ch == 'O' ||ch == 'U')
//                 {
//                     arr.add(ch);
//                 }
//         }

//         int k = arr.size()-1;

//         for(int i=0;i<s.length();i++)
//         {
//             char ch = s.charAt(i);
//             if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'U' ||
//                 ch == 'A' ||ch == 'E' ||ch == 'I' ||ch == 'O' ||ch == 'U')
//                 {
//                     sb.append(arr.get(k));
//                     k--;
//                 }else{
//                     sb.append(ch);
//                 }
//         }

//         return sb.toString();
        
//     }
// }


class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right) {
            // Move left pointer until we find a vowel
            while(left < right && !isVowel(chars[left])) {
                left++;
            }
            // Move right pointer until we find a vowel
            while(left < right && !isVowel(chars[right])) {
                right--;
            }
            // Swap vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            left++;
            right--;
        }
        
        return new String(chars);
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}