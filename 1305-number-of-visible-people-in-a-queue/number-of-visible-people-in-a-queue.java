class Solution {
    public int[] canSeePersonsCount(int[] height) {

        int n = height.length;
        //define Stack of integer
        Stack<Integer> st = new Stack<>();

        // Define ans array
        int[] ans = new int[n];

        ans[n-1] = 0;
        st.push(n-1);

        for(int i=n-2;i>=0;i--)
        {
            while(!st.isEmpty() && height[st.peek()] < height[i])
            {
                ans[i]++;
                st.pop();
            }

            if(!st.isEmpty())
            {
                ans[i]++;
            }
            st.push(i);
        }

        return ans;

        
    }
}