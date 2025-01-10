class Solution {

    // public List<String> wordSubsets(String[] words1, String[] words2) {
    //     HashSet<String> hs = new HashSet<>();
    //     for(int i=0;i<words2.length;i++)
    //     {
    //         hs.add(words2[i]);
    //     }

    //     ArrayList<String> ans = new ArrayList<>();


    //     // iterate in words1
    //     for(int i=0;i<words1.length;i++)
    //     {
    //         HashSet<String> hs1 = new HashSet<>();
    //         for(String s:hs)
    //         {
    //             if(words1[i].contains(s))
    //             {
    //                 hs1.add(s);
    //             }
    //         }

    //         // if(hs1.isEmpty())
    //         // {
    //         //     ans.add(words1[i]);
    //         // }

    //         if(hs1 == hs)
    //         {
    //             ans.add(words1[i]);
    //         }
                
    //     }

    //         return ans;
            
    //     }
        
        
    // }

    public static HashMap<Character,Integer> counter (String str)
    {
         HashMap<Character,Integer> hm = new HashMap<>();

        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);

        }
        return hm;
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {

        HashMap<Character,Integer> uni = new HashMap<>();

        for(int i=0;i<words2.length;i++)
        {
            HashMap<Character,Integer> hm = counter(words2[i]);
            for(Character ch : hm.keySet())
            {
                uni.put(ch,Math.max(uni.getOrDefault(ch, 0),hm.get(ch)));
                
            }
        }

        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<words1.length;i++)
        {
            boolean flag = true;
            HashMap<Character,Integer> hm1 = counter(words1[i]);
            for(Character ch : uni.keySet())
            {
                if(hm1.getOrDefault(ch,0) < uni.get(ch))
                {
                    flag = false;
                    break;
                }
            }

            if(flag)
            {
                ans.add(words1[i]);
            }
            
        }
        

        return ans;


        
    }
    }

