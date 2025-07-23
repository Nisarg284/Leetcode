class Solution {
    public int longestContinuousSubstring(String s) {

        


        // int i = 0;
        // int j = 1;
        int n = s.length();

        if(s.length() == 0)
        {
            return 0;
        }

        int max = 1;
        int count = 1;

        for(int i = 0 ;i < n-1;i++)
        {
            char curr = s.charAt(i);
            char next = s.charAt(i+1);

            if(next - curr == 1)
            {
                // System.out.println("curr : "+ curr + " next: "+next);
                count++;
            }else{
                count = 1;
            }

            max = Math.max(count,max);
        }



        return max;
        
    }
}


// a b a c a b a

// i
   

// count = 2