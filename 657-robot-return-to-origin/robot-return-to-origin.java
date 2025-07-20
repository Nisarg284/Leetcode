class Solution {
    public boolean judgeCircle(String moves) {

        int n = moves.length();

        // int[][] robot = new int[n][n];
        int[] robot = new int[2];

        // HashMap<Character,

        for(int i = 0;i<n;i++)
        {
            int ch = moves.charAt(i);
            if(ch == 'U')
            {
                robot[0] -= 1;
            }else if(ch == 'R')
            {
                robot[1] += 1;
            }else if(ch == 'D')
            {
                robot[0] += 1;
            }else{
                robot[1] -= 1;
            }
        }

        return robot[0] == 0 && robot[1] == 0; 
        
    }
}