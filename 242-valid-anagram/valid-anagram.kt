class Solution {
    fun isAnagram(s: String, t: String): Boolean {


        if(s.length != t.length)
        {
            return false
        }


        val map = mutableMapOf<Char,Int>()

        for(i in s.indices){
            map[s[i]] = (map[s[i]] ?:0)+1
        }

        for(i in t.indices){

            if(t[i] !in map)
            {
                return false
            }

            if(map[t[i]] == 1)
            {
                map.remove(t[i])
            }else{
                map[t[i]] = map[t[i]] !! -1
            }
        }

        return map.isEmpty()
        
    }
}