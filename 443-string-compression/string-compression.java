class Solution {
    public int compress(char[] chars) {

        int n = chars.length;
        if(n == 1){
            return 1;
        }

        int i = 0;
        int j = 0;

        char curr = chars[0];
        int count = 0;

        StringBuilder sb = new StringBuilder();

        while(j < n){

            if(curr == chars[j]){
                count++;
                j++;
            }else{
                sb.append(count > 1 ? curr +""+ count : curr);
                i = j;
                // j++;
                count = 0;
                curr = chars[i];
            }
        }

        sb.append(count > 1 ? curr +""+ count : curr);

        for(i = 0;i<sb.length();i++){

            char ch = sb.charAt(i);
            chars[i] = ch;
        }



        return sb.length();
        
    }
}