class Solution {

    public static boolean isVowel(char ch)
    {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o'|| ch=='u')
        {
            return true;
        }
        return false;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {

        int[] prefixSum = new int[words.length+1];

        for(int i=0;i<words.length;i++)
        {
            char first = words[i].charAt(0);
            char last = words[i].charAt(words[i].length()-1);


            if(isVowel(first) && isVowel(last))
            {
                prefixSum[i+1] = prefixSum[i]+1;
            }else{
                prefixSum[i+1] = prefixSum[i];
            }
        }

        int[] ans = new int[queries.length];

        for(int i=0;i<queries.length;i++)
        {
            int start = queries[i][0];
            int end = queries[i][1];

            ans[i] = prefixSum[end+1] - prefixSum[start];
        }

        return ans;



        // HashMap<Integer,String> hm = new HashMap<>();

        // for(int i=0;i<words.length;i++)
        // {
        //     char first = words[i].charAt(0);
        //     char last = words[i].charAt(words[i].length()-1);
            
            
        //     if((first == 'a' || first == 'e' || first == 'i' || first == 'o'|| first=='u') &&
        //     (last == 'a' || last == 'e' || last == 'i' || last == 'o'|| last == 'u'))
        //     {
        //         hm.put(i,words[i]);
        //     }
            
        // }

        // int count=0;
        // int[] ans = new int[queries.length];

        // for(int i=0;i<queries.length;i++)
        // {
        //     for(int j=queries[i][0];j<=queries[i][1];j++)
        //     {
        //         if(hm.containsKey(j))
        //         {
        //             count++;
        //         }
        //     }
        //     ans[i] = count;
        //     count = 0;
        // }
        // return ans;
        
    }
}