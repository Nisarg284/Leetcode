class Solution {
    public int scoreOfString(String s) {

        int sum=0;
        

        int i=0;
        int j=1;

        while(j<s.length())
        {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            sum+=(Math.abs(ch1-ch2));

            i++;
            j++;
        }

        return sum;
    }
}