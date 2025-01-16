class Solution {
    public String reversePrefix(String word, char ch) {

        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx = -1;

        for(int i=0;i<word.length();i++)
        {
            char curr = word.charAt(i);
             st.push(curr);
            if(curr == ch)
            {
               
                while(!st.isEmpty())
                {
                    sb.append(st.pop());
                }

                idx = i;
                break;
            }
            // }else{
            //     st.push(curr);
            // }
        }

        
            for(int i=idx+1;i<word.length();i++)
            {
                sb.append(word.charAt(i));
            }

return sb.toString();

       
        
    }
}