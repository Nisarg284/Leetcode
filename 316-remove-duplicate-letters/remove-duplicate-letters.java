// class Solution {
//     public static int minIdx(String str)
//     {
//         int min = 0;

//         for(int i=1;i<str.length();i++)
//         {
//             char curr = str.charAt(min);
//             char next = str.charAt(i);
//             if(curr > next)
//             {
//                 min = i;
//                 System.out.println(min);
//             }
//         }
//         return min;
//     }

//     public static String removeDuplicateLetters(String str)
//     {
//         if(str.length()< 2)
//         {
//             return str;
//         }
//         Set<Character> hs = new HashSet<>();
//         StringBuilder sb = new StringBuilder();
//         Queue<Character> q = new LinkedList<>();


//         // This is for extracting duplicates from string Also add all characters in q for further operations
//         for(int i=0;i<str.length();i++)
//         {
//             char ch = str.charAt(i);
//             if(!hs.contains(ch))
//             {
//                 sb.append(ch);
//                 hs.add(ch);
//             }
//             q.add(ch);
//         }

//         // Get minimum element index from string
//         int minIdx = minIdx(sb.toString());

//         while(q.peek()!=sb.charAt(minIdx))
//         {
//             q.remove();
//         }

//         StringBuilder sb1 = new StringBuilder();
//         hs.clear();

//         while(!q.isEmpty())
//         {

//             if(!hs.contains(q.peek()))
//             {
//                 hs.add(q.peek());
//                 sb1.append(q.peek());
//             }

//             q.remove();

//         }

//         // if(sb.length() != sb1.length())
//         // {
//         //     int diff = sb.length() - sb1.length();
//         //     sb.replace(diff,sb.length(),sb1.toString());
//         //     return sb.toString();
//         // }

//         return sb1.toString();
//      }
// }


class Solution{
    public static String removeDuplicateLetters(String str)
    {
        // Create a HashMap for Tracking last occurence of every character
        HashMap<Character,Integer> hm = new HashMap<>();

        // fill  HashMap
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            hm.put(ch,i);   
        }

        // Define Stack
        Stack<Character> st = new Stack<>();

        // Define HashSet for tracking presense of character in stack
        HashSet<Character> hs = new HashSet<>();

        st.push(str.charAt(0));
        hs.add(str.charAt(0));

        for(int i=1;i<str.length();i++)
        {
            char curr = str.charAt(i);

            if(hs.contains(curr))
            {
                continue;
            }

            while(!st.isEmpty() && curr < st.peek() && hm.get(st.peek()) > i)
            {
                hs.remove(st.pop());
            }
            
            // if(!hs.contains(curr))
            // {
                st.push(curr);
                hs.add(curr);
            // }
           
        }

        StringBuilder ans = new StringBuilder();

        while(!st.isEmpty())
        {
            ans.append(st.pop());
        }

        ans.reverse();

        return ans.toString();
    }

}