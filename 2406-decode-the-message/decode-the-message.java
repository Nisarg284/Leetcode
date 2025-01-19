class Solution {
    public String decodeMessage(String key, String message) {

        HashMap<Character,Character> hm = new HashMap<>();

        char alpha = 'a';
        for(int i=0;i<key.length();i++)
        {
            char curr = key.charAt(i);

            if(!hm.containsKey(curr) && curr != ' ')
            {
                hm.put(curr,alpha);
                alpha++;
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i=0;i<message.length();i++)
        {
            char ch = message.charAt(i);
            if(ch == ' ')
            {
                ans.append(' ');
            }
            else{
                ans.append(hm.get(ch));
            }
            
        }

        return ans.toString();
        
    }
}