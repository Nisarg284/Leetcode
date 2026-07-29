class Solution {
    public String longestCommonPrefix(String[] strs) {

        int n = strs.length;
        Arrays.sort(strs);

        String smallest = strs[0];
        String longest = strs[n-1];

        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<smallest.length();i++){

            if(smallest.charAt(i) == longest.charAt(i)){
                sb.append(smallest.charAt(i));
            }else{
                break;
            }
        }

        return sb.toString();

        
    }
}