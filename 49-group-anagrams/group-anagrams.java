class Solution {
    public static String alphaSorting(String str) {
        ArrayList<Character> al = new ArrayList<>();

        for(int i=0;i<str.length();i++)
        {
            al.add(str.charAt(i));
        }

        Collections.sort(al);
        StringBuffer sb = new StringBuffer();

        for(int i=0;i<al.size();i++)
        {
            sb.append(al.get(i));
        }
        return sb.toString();
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        // Define hashMap of String:List
        HashMap<String, List<String>> hm = new HashMap<>();

        List<List<String>> ans = new ArrayList<>();

        for (String s : strs) {
            String sorted = alphaSorting(s);

            if(!hm.containsKey(sorted))
            {
                List<String> l = new ArrayList<>();
                l.add(s);
                hm.put(sorted, l);
            }else{
                hm.get(sorted).add(s);
            }
        }

        // now iterate in HashMap & store every List in List array
        for(String s : hm.keySet())
        {
            ans.add(hm.get(s));
        }
        return ans;
    }
}