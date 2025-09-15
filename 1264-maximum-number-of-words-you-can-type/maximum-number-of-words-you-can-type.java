class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {

        HashSet<Character> hs = new HashSet<>();
        for(int i = 0;i<brokenLetters.length();i++)
        {
            char ch = brokenLetters.charAt(i);
            hs.add(ch);
        }

        String[] arr = text.split(" ");
        int canMake = arr.length;
        for(int i = 0;i<arr.length;i++)
        {
            String currStr = arr[i];

            for(int j = 0;j<currStr.length();j++)
            {
                char ch = currStr.charAt(j);
                if(hs.contains(ch))
                {
                    canMake--;
                    break;
                }
            }

        }

        return canMake;
        
    }
}