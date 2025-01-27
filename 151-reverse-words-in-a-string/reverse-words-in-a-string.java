class Solution {
    public String reverseWords(String s) {

        s=s.trim();

        Stack<String> st = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch == ' ')
            {
                if( sb.length() >0)
                {
                    st.push(sb.toString());
                // st.push(" ");
                sb.delete(0,s.length());
                }
                
            }else{
                sb.append(ch);
            }
        }

        st.push(sb.toString());


        StringBuilder ans = new StringBuilder();

        while(!st.isEmpty())
        {
            ans.append(st.pop());
            ans.append(" ");
        }

        // for(int i=0;i<ans.length()-1;i++)
        // {

        //     if(ans.charAt(i) ==' ' &&  ans.charAt(i+1)== ' ')
        //     {
        //         ans.deleteCharAt(i);
        //     }
        // }


        String ans1 = ans.toString();

        ans1 = ans1.trim();

        return ans1;


        
        
    }
}