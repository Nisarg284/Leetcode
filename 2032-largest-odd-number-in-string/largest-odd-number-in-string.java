class Solution {
    public String largestOddNumber(String num) {




            int idx = -1;
        for(int i=num.length()-1;i>=0;i--)
        {
            int ab = Character.getNumericValue(num.charAt(i));

            if(ab%2 != 0)
            {
                idx = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<=idx;i++)
        {
            sb.append(num.charAt(i));
        }

        if(idx == -1)
        {
            return "";
        }

        return sb.toString();


        
    }
}