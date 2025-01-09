class Solution {
    public String mergeAlternately(String word1, String word2) {

        int i=0;
        int j=0;

        StringBuilder sb = new StringBuilder();

        while(i<word1.length() && j<word2.length())
        {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(j);

            sb.append(ch1);
            sb.append(ch2);

            i++;
            j++;
        }
        
        while(i<word1.length())
        {
            char ch1 = word1.charAt(i);
            sb.append(ch1);
            i++;
        }

        while(j<word2.length())
        {
            char ch2 = word2.charAt(j);
            sb.append(ch2);
            j++;
        }

        return sb.toString();
        
    }
}