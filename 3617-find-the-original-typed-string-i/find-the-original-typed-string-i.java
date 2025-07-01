class Solution {
    public int possibleStringCount(String word) {


        int count = 1;

        for(int i = 0;i<word.length()-1;i++)
        {
            char curr = word.charAt(i);
            char next = word.charAt(i+1);
        
            if(curr == next)
            {
                count++;
            }
        }

        return count;
        
    }
}