class Solution {
    public int[] minOperations(String boxes) {

        int ans[] = new int[boxes.length()];
        int sum = 0;

        for(int i=0;i<boxes.length();i++)
        {
            for(int j=0;j<boxes.length();j++)
            {
                char ch = boxes.charAt(j);
                if(ch == '1')
                {
                    sum += Math.abs(i-j);
                }
            }
            ans[i] = sum;
            sum = 0;
        }

        return ans;
        
    }
}