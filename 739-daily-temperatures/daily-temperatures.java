class Solution {
    public int[] dailyTemperatures(int[] arr) {

        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        

        st.push(n-1);
        ans[n-1] = 0;
        int min = Integer.MAX_VALUE;

        for(int i = n-2;i>=0;i--)
        {
            // int count = 1;
        

            while(!st.isEmpty() && arr[st.peek()] <= arr[i])
            {
                st.pop();
                // count++;
            }

            if(st.isEmpty())
            {
                ans[i] = 0;
            }else{
                int diff = st.peek()-i;
                ans[i] = diff;
            }

            st.push(i);
        }

        return ans;
        
    }
}