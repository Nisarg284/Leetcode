// class Solution {

//     public List<String> wordSubsets(String[] words1, String[] words2) {
//         HashSet<String> hs = new HashSet<>();
//         for(int i=0;i<words2.length;i++)
//         {
//             hs.add(words2[i]);
//         }

//         ArrayList<String> ans = new ArrayList<>();


//         // iterate in words1
//         for(int i=0;i<words1.length;i++)
//         {
//             HashSet<String> hs1 = new HashSet<>();
//             for(String s:hs)
//             {
//                 if(words1[i].contains(s))
//                 {
//                     hs1.add(s);
//                 }
//             }

//             // if(hs1.isEmpty())
//             // {
//             //     ans.add(words1[i]);
//             // }

//             if(hs1 == hs)
//             {
//                 ans.add(words1[i]);
//             }
                
//         }

//             return ans;
            
//         }
        
        
//     }

//     // public HashMap<Character,Integer> counter (String str)
//     // {
//     //      HashMap<Character,Integer> hm = new HashMap<>();

//     //     for(int i=0;i<str.length();i++)
//     //     {
//     //         char ch = str.charAt(i);
//     //         hm.put(ch,hm.getOrDefault(ch,0)+1);

//     //     }
//     //     return hm;
//     // }
//     // public List<String> wordSubsets(String[] words1, String[] words2) {

//     //     HashMap<Character,Integer> uni = new HashMap<>();

//     //     for(int i=0;i<words2.length;i++)
//     //     {
//     //         HashMap<Character,Integer> hm = counter(words2[i]);
//     //         for(Character ch : hm.keySet())
//     //         {

//     //             if(uni.containsKey(ch))
//     //             {
//     //                 if(hm.get(ch)<= uni.get(ch))
//     //                 {
//     //                     uni.put(ch,hm.get(ch));
//     //                 }
//     //             }else{
//     //                 uni.put(ch,hm.get(ch));
//     //             }
                
//     //         }
//     //     }

//     //     ArrayList<String> ans = new ArrayList<>();
//     //     for(int i=0;i<words1.length;i++)
//     //     {
//     //         boolean flag = true;
//     //         HashMap<Character,Integer> hm1 = counter(words1[i]);
//     //         for(Character ch : uni.keySet())
//     //         {
//     //              if(hm1.containsKey(ch))
//     //             {
//     //                 if(hm1.get(ch)< uni.get(ch)){
                        
//     //                     flag = false;
//     //                     break;
//     //                 }
//     //             }
//     //             else{
//     //                 flag = false;
//     //                 break;
//     //             }
//     //         }

//     //         if(flag)
//     //         {
//     //             ans.add(words1[i]);
//     //         }
            
//     //     }
        

//     //     return ans;


        
//     // }


public class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Create a frequency map for the maximum count of each character in words2
        int[] maxFreq = new int[26];
        for (String word : words2) {
            int[] freq = getFrequency(word);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        List<String> result = new ArrayList<>();

        // Check each word in words1
        for (String word : words1) {
            int[] freq = getFrequency(word);
            boolean isUniversal = true;

            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }

            if (isUniversal) {
                result.add(word);
            }
        }

        return result;
    }

    private int[] getFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}