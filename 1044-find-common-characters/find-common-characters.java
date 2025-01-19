class Solution {
    public List<String> commonChars(String[] words) {

        HashMap<Character,Integer> global = new HashMap<>();

        for(int i=0;i<words[0].length();i++)
        {
            char ch = words[0].charAt(i);
            global.put(ch,global.getOrDefault(ch,0)+1); 
        }

        for(int i=1;i<words.length;i++)
        {
            String curr = words[i];
            HashMap<Character,Integer> local = new HashMap<>();
            for(int j=0;j<curr.length();j++)
            {
                char ch = curr.charAt(j);
                local.put(ch,local.getOrDefault(ch,0)+1); 
            }

            for(char ch:global.keySet())
            {
                if(!local.containsKey(ch))
                {
                    global.put(ch,0);
                }else{
                    global.put(ch,Math.min(local.get(ch),global.get(ch)));
                }
            }

        }

        ArrayList<String> ans = new ArrayList<>();
        
        for(char ch:global.keySet())
        {
            if(global.get(ch) > 0)
            {
                for(int i=0;i<global.get(ch);i++)
                {
                    StringBuilder sb = new StringBuilder();
                    sb.append(ch);
                    ans.add(sb.toString());
                }
            }
        }

        return ans;
        
    }
}