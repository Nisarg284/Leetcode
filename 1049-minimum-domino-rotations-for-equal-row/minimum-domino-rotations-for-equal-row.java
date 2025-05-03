// class Solution {

//     public int minDominoRotations(int[] tops, int[] bottoms) {
//         int n = tops.length;
//         // int m = bottoms.length;

//         HashMap<Integer,Integer> hm = new HashMap<>();

//         for (int i = 0; i < n; i++) {
//             hm.put(tops[i],hm.getOrDefault(tops[i], 0) + 1);
//         }

//         int arr1Max = 0;
//         int arr1Freq = 0;

//         for (int i : hm.keySet()) {
//             int val = i;
//             int freq = hm.get(i);

//             if (freq > arr1Freq) {
//                 arr1Freq = freq;
//                 arr1Max = val;

//             }
//         }

//         int arr1Swaps = 0;

//         for (int i = 0; i < n; i++) 
//         {
//             if (tops[i] != arr1Max && bottoms[i] != arr1Max) {
//                 arr1Swaps = Integer.MAX_VALUE;
//                 break;
//             } 

//             if(tops[i] != arr1Max)
//             {
//                 arr1Swaps++;
//             }
//         }

//         // 2nd half

//         HashMap<Integer,Integer> hm1 = new HashMap<>();

//         for (int i = 0; i < n; i++) {
//             hm1.put(tops[i],hm1.getOrDefault(bottoms[i], 0) + 1);
//         }

//         int arr2Max = 0;
//         int arr2Freq = 0;

//         for (int i : hm1.keySet()) {
//             int val = i;
//             int freq = hm1.get(i);

//             if (freq > arr2Freq) {
//                 arr2Freq = freq;
//                 arr2Max = val;
//             }
//         }

//         int arr2Swaps = 0;

//         for (int i = 0; i < n; i++) {
//             if (bottoms[i] != arr2Max && tops[i] != arr2Max) {
//                 arr2Swaps = Integer.MAX_VALUE;
//                 break;
//             } 

//             if(bottoms[i] != arr2Max)
//             {
//                 arr2Swaps++;
//             }
//         }

//         if(arr1Swaps == Integer.MAX_VALUE && arr2Swaps == Integer.MAX_VALUE )
//         {
//             return -1;
//         }

//         if (arr1Swaps == Integer.MAX_VALUE) return arr2Swaps;
//         if (arr2Swaps == Integer.MAX_VALUE) return arr1Swaps;

//         return Math.min(arr1Swaps,arr2Swaps);

//     }

// }


class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        
        // First array (tops) analysis
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        // Count frequencies in tops
        for (int i = 0; i < n; i++) {
            hm.put(tops[i], hm.getOrDefault(tops[i], 0) + 1);
        }
        
        int arr1Max = 0;
        int arr1Freq = 0;
        
        // Find most frequent value in tops
        for (int val : hm.keySet()) {
            int freq = hm.get(val);
            if (freq > arr1Freq) {
                arr1Freq = freq;
                arr1Max = val;
            }
        }
        
        int arr1Swaps = 0;
        // Check if we can make all dominos match arr1Max
        for (int i = 0; i < n; i++) {
            if (tops[i] != arr1Max && bottoms[i] != arr1Max) {
                arr1Swaps = Integer.MAX_VALUE;
                break;
            }
            if (tops[i] != arr1Max) {
                arr1Swaps++;
            }
        }
        
        // Second array (bottoms) analysis
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        
        // Count frequencies in bottoms (fixed typo from 'customs' to 'bottoms')
        for (int i = 0; i < n; i++) {
            hm1.put(bottoms[i], hm1.getOrDefault(bottoms[i], 0) + 1);
        }
        
        int arr2Max = 0;
        int arr2Freq = 0;
        
        // Find most frequent value in bottoms
        for (int val : hm1.keySet()) {
            int freq = hm1.get(val);
            if (freq > arr2Freq) {
                arr2Freq = freq;
                arr2Max = val;
            }
        }
        
        int arr2Swaps = 0;
        // Check if we can make all dominos match arr2Max
        for (int i = 0; i < n; i++) {
            if (bottoms[i] != arr2Max && tops[i] != arr2Max) {
                arr2Swaps = Integer.MAX_VALUE;
                break;
            }
            if (bottoms[i] != arr2Max) {
                arr2Swaps++;
            }
        }
        
        if (arr1Swaps == Integer.MAX_VALUE && arr2Swaps == Integer.MAX_VALUE) {
            return -1;
        }
        
        // If one approach is impossible, return the other if valid
        if (arr1Swaps == Integer.MAX_VALUE) return arr2Swaps;
        if (arr2Swaps == Integer.MAX_VALUE) return arr1Swaps;
        
        return Math.min(arr1Swaps, arr2Swaps);
    }
}