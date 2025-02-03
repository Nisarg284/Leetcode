class Solution {
    public String convert(String s, int numRows) {

     
   StringBuilder[] sb = new StringBuilder[numRows];

        // put empty StringBuilder object in every index
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int i = 0;
        int n = s.length();
        while (i < n) {
            // add from forward
            for (int j = 0; j < sb.length; j++) {
                if (i > n-1) {
                    break;
                }
                char ch = s.charAt(i);
                sb[j].append(ch);
                i++;
            }


            // add from backward

            for (int j = sb.length-2; j >= 1; j--) {
                if (i > n-1) {
                    break;
                }
                char ch = s.charAt(i);
                sb[j].append(ch);
                i++;
            }
        }


        StringBuilder ans = new StringBuilder();

        // now combine all strings of array into one string
        for (int j = 0; j < sb.length; j++) {
            ans.append(sb[j]);
        }

        return ans.toString();
        
    }
}