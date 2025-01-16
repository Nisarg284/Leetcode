class Solution {
    public String removeDuplicates(String s) {

        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();


        for(int i=0;i<sb.length();i++)
        {
            if(!st.isEmpty() && sb.charAt(i) == sb.charAt(st.peek()))
            {   
                sb.deleteCharAt(i);
                sb.deleteCharAt(st.pop());
                
                i-=2;
            }else{
                st.push(i);
            }
           
        }

        return sb.toString();

        
        
    }
}