class Solution {
    public boolean isPalindrome(String s) {

        int n = s.length();

        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }
        }

        int i = 0;
        int j = sb.length()-1;

        while( i < j){
            if(sb.charAt(i) != sb.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
        
    }
}