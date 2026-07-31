class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {


        int n = nums2.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        int[] subAns = new int [n];
        st.add(nums2[n-1]);
        subAns[n-1] = -1;

        hm.put(nums2[n-1],subAns[n-1]);

        int i = n-2;

        while(i >= 0){

            while(!st.isEmpty() && st.peek() < nums2[i]){
                st.pop();
            }

            if(st.isEmpty()){
                subAns[i] = -1;
            }else{
                subAns[i] = st.peek();
            }

            st.add(nums2[i]);
            hm.put(nums2[i],subAns[i]);
            i--;
        }

        System.out.println("map --------> "+hm);

        for(int k : subAns){
            System.out.print(k+" ");
        }


        int[]ans = new int[nums1.length];

        for(int k = 0;k < nums1.length;k++){

            ans[k] = hm.get(nums1[k]);

        }

        return ans;
        
    }
}