class Solution {
    public String reverseWords(String s) {

        String[]arr = s.split(" ");

        int n = arr.length;

        // int i = 0;
        // int j = arr.length;


        StringBuilder sb = new StringBuilder();

        for(int i = n-1;i>=0;i--){

                
            String curr = arr[i];

            if(curr.isBlank()){
                continue;
            }
            sb.append(curr+" ");
        }

        return sb.toString().trim();
        
        
    }
}