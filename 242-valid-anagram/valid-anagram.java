class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        int n = s.length();
        Map<Character,Integer> hm = new HashMap<>();

        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            hm.put(
                curr,
                hm.getOrDefault(curr,0)+1
                );
        }

        for(int i = 0;i<n;i++){

            char curr = t.charAt(i);

            if(!hm.containsKey(curr)){
                return false;
            }

            if(hm.get(curr) == 1){
                hm.remove(curr);
            }else{
                hm.put(curr,hm.get(curr)-1);
            }
        }

        System.out.println(hm);

        return hm.isEmpty();
        
    }
}