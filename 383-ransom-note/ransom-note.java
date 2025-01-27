class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i=0;i<magazine.length();i++)
        {
            char ch = magazine.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }


        for(int i=0;i<ransomNote.length();i++)
        {
            char ch = ransomNote.charAt(i);

            if(!hm.containsKey(ch))
            {
                return false;
            }else{
                if(hm.get(ch) == 1)
                {
                    hm.remove(ch);
                }else{
                    hm.put(ch,hm.get(ch)-1);
                }
            }
            
        }
        return true;

        
    }
}