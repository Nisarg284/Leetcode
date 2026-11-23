class Solution {

    public static String reverse(String str){

        StringBuilder sb = new StringBuilder(str);


        int i = 0;
        int j = str.length()-1;

        while(i < j){
            char first = sb.charAt(i);
            char last = sb.charAt(j);

            sb.setCharAt(i,last);
            sb.setCharAt(j,first);

            i++;
            j--;
        }

        return sb.toString();
    }
    public String reverseWords(String s) {

        String[]arr = s.split(" ");
        StringBuilder ans = new StringBuilder();

        for(int i = 0;i<arr.length;i++){

            // String revStr = reverse(arr[i]);

            // arr[i] = revStr;

            ans.append(reverse(arr[i]));
            if(i <arr.length-1){
                ans.append(" ");
            }
        }

        return ans.toString();


        
    }
}