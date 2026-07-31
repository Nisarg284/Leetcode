class Solution {
    public boolean isValid(String s) {

        Map<Character,Character> hm = new HashMap<>();

        Stack<Character> st = new Stack<>();
        int n = s.length();

        hm.put(')','(');
        hm.put('}','{');
        hm.put(']','[');


        for(int i = 0;i<n;i++){

            char curr = s.charAt(i);
            if(curr == '(' || curr == '[' || curr == '{'){
                st.add(curr);
            }
            else{

                if(st.isEmpty()){
                    return false;
                }

                if(hm.get(curr) != st.peek()){
                    return false;
                }else{
                    st.pop();
                }
            }
        }


        return st.isEmpty();


        
        
    }
}