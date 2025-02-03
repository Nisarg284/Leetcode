class Solution {
    public static String alphaSorting(String str)
    {
        ArrayList<Character> strList = new ArrayList<>();

        // inserting str characters into list
        for(int i=0;i<str.length();i++)
        {
            char curr = str.charAt(i);
            strList.add(curr);
        }

        // sort list using collections.sort
        Collections.sort(strList);

        StringBuilder sb = new StringBuilder();

        // insert sorted characters in sb 
        for(int i=0;i<strList.size();i++)
        {
            char curr = strList.get(i);
            sb.append(curr);
        }
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> list = new ArrayList<>();

        int n = strs.length;

        // create HashMap
        HashMap<String,List<String>> hm = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            String sorted = alphaSorting(strs[i]);
            String unSorted = strs[i];

           // List<String> l1 = new ArrayList<>();

            if(!hm.containsKey(sorted))
            {
                List<String> st4 = new ArrayList<>();
                st4.add(unSorted);
                hm.put(sorted,st4);
            }else
            {
                List<String> st4 = hm.get(sorted);
                st4.add(unSorted);
                hm.put(sorted,hm.getOrDefault(sorted,st4));
            }

        }


        for(String st : hm.keySet())
        {
            List<String> st2 = hm.get(st);

            list.add(st2);
        }

        return list;
    }
}