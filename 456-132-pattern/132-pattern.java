class Solution {
    public boolean find132pattern(int[] nums) {

        // int n = nums.length;

        // // Stores previous Minimum value
        // int[] prev = new int[n];

        // Stack<Integer> st = new Stack<>();

        // prev[0] = -1;
        // st.push(nums[0]);

        // for(int i = 1;i<n;i++)
        // {
        //     while(!st.isEmpty() && st.peek()>=nums[i])
        //     {
        //         st.pop();
        //     }
            
        //     if(st.isEmpty())
        //     {
        //         prev[i] = -1;
        //     }else{
        //         prev[i] = st.peek();
        //     }
        //     st.push(nums[i]);
        // }

        // st.clear();

        // // Store next minimum value
        // int[] next = new int[n];

        // next[n-1] = -1;
        // st.push(n-1);

        // for(int i = n-2;i>=0;i--)
        // {
        //     while(!st.isEmpty() && st.peek() >= nums[i])
        //     {
        //         st.pop();
        //     }

        //     if(st.isEmpty())
        //     {
        //         next[i] = -1;
        //     }else{
        //         next[i] = st.peek();
        //     }
        //     st.push(nums[i]);
        // }


        // for(int i=1;i<n;i++)
        // {
        //     if(prev[i] < next[i] && next[i] < nums[i])
        //     {
        //         return true;

        //     }
        // }

        // return false;

        Stack<Integer> st = new Stack<>();
        int secondMax = Integer.MIN_VALUE;

        int n = nums.length;

        for(int i=n-1;i>=0;i--)
        {
            if(secondMax > nums[i])
            {
                return true;
            }

            while(!st.isEmpty() && nums[i] > st.peek())
            {
                secondMax = Math.max(secondMax,st.pop());
            }

            st.push(nums[i]);
        }

        return false;


        
    }


}