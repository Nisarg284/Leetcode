class Solution {
    public String smallestSubsequence(String s) {

        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            hm.put(s.charAt(i),i);
        }

        Stack<Character> st = new Stack<>();
        HashSet<Character> hs = new HashSet<>();

        st.push(s.charAt(0));
        hs.add(s.charAt(0));

        for(int i=1;i<s.length();i++)
        {
            char curr = s.charAt(i);

            if(!hs.contains(curr))
            {
                while(!st.isEmpty() && curr < st.peek() && hm.get(st.peek()) > i)
                {
                    hs.remove(st.pop());
                }

                st.push(curr);
                hs.add(curr);
            }
        }

        StringBuilder ans = new StringBuilder();

        while(!st.isEmpty())
        {
            ans.append(st.pop());
        }

        ans.reverse();

        return ans.toString();

        
    }
}