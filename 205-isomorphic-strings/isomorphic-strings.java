class Solution {
    public boolean isIsomorphic(String s, String t) {

        if(s.length()!=t.length())
        {
            return false;
        }

        HashMap<Character,Character> hm1 = new HashMap<>();
        HashMap<Character,Character> hm2 = new HashMap<>();


        for(int i=0;i<s.length();i++)
        {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            hm1.put(ch1,ch2);
            hm2.put(ch2,ch1);
        }

        for(int i=0;i<s.length();i++)
        {
            char ch1 = s.charAt(i);
            char ch2= t.charAt(i);


            if(hm1.get(ch1) != ch2)
            {
                return false;
            }
            if(hm2.get(ch2)!= ch1)
            {
                return false;
            }
          
        }

        return true;
        
    }
}



// class Solution {
//     public boolean isIsomorphic(String s, String t) {

//         if(s.length()!=t.length())
//         {
//             return false;
//         }

//         HashMap<Character,Character> hm = new HashMap<>();

//         for(int i=0;i<s.length();i++)
//         {
//             char ch1 = s.charAt(i);
//             char ch2= t.charAt(i);
            

//             if(!hm.containsKey(ch1))
//             {
//                 hm.put(ch1,ch2);
//             }else{
//                 if(hm.containsKey(ch1)  && ch2 != hm.get(ch1))
//                 {
//                     return false;
//                 }
//             }
//         }

//         return true;
        
//     }
// }