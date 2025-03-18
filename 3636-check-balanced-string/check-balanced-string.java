class Solution {
    public boolean isBalanced(String num) {

        int oddIdx = 0;
        int evenIdx = 0;

        for(int i = 0;i<num.length();i++)
        {
            char ch = num.charAt(i);
            int curr = Character.getNumericValue(ch);
            if(i%2 == 0)
            {
                evenIdx += curr;
            }else{
                oddIdx += curr;
            }
        }

        return evenIdx == oddIdx;

        
        
    }
}