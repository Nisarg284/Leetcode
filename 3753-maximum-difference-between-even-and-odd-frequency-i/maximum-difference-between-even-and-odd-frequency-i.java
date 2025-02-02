class Solution {
    public int maxDifference(String s) {
         HashMap<Character, Integer> hm = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }

        int odd = Integer.MIN_VALUE;
        int even = Integer.MAX_VALUE;

        for(char c : hm.keySet())
        {
            if(hm.get(c) %2 == 0)
            {
                even = Math.min(even, hm.get(c));
            }else{
                odd = Math.max(odd, hm.get(c));

            }
        }

        return odd - even;

        
    }
}