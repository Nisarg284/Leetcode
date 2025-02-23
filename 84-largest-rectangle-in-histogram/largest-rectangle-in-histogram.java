class Solution {
    public int largestRectangleArea(int[] height) {
        int n = height.length;

        // Define Stack to store prevSmaller / nextSmaller index
        Stack<Integer> st = new Stack<>();

        // define axillary array to Store PrevSmaller index
        int[] prevSmaller = new int[n];

        prevSmaller[0] = -1;
        st.push(0);

        // find prevSmaller indices
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                prevSmaller[i] = -1;
            } else {
                prevSmaller[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        // now find nextSmaller indices
        int[] nextSmaller = new int[n];
        nextSmaller[n - 1] = n;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nextSmaller[i] = n;
            } else {
                nextSmaller[i] = st.peek();
            }
            st.push(i);
        }

        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currArea = height[i] * (nextSmaller[i] - (prevSmaller[i] + 1));
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;

    }
}