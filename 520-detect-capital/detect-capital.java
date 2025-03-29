class Solution {
    public boolean detectCapitalUse(String word) {

        int n = word.length();

        int count = 0;

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch)) {
                count++;
            } 
        }

        return count == n || count == 0 || (count == 1 && Character.isUpperCase(word.charAt(0)));
    }
}