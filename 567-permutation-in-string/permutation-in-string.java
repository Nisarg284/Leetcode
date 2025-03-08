class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length())
        {
            return false;
        }

        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();

        int m = s1.length();
        int n = s2.length();

        for(int i=0;i<m;i++)
        {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            hm1.put(ch1,hm1.getOrDefault(ch1,0)+1);
            hm2.put(ch2,hm2.getOrDefault(ch2,0)+1);
        }

        if(hm2.equals(hm1))
        {
            return true;
        }

        int i = 1;
        int j = m;

        while(j<n)
        {
            char ch1 = s2.charAt(j);
            char ch2 = s2.charAt(i-1);

            hm2.put(ch1,hm2.getOrDefault(ch1,0)+1);

            if(hm2.get(ch2) == 1)
            {
                hm2.remove(ch2);
            }else{
                hm2.put(ch2,hm2.get(ch2)-1);
            }

            if(hm2.equals(hm1))
            {
                return true;
            }
            i++;
            j++;

        }

        return false;

        
    }
}