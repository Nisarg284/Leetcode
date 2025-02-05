class Solution {
    public boolean isSubsequence(String s, String t) {

        if(s.isEmpty())
        {
            return true;
        }

        int i = 0;

        for (int j = 0; j < t.length() && i < s.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

        }
        return i== s.length();

    }
}