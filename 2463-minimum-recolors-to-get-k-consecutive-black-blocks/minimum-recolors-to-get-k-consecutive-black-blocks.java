class Solution {
    public int minimumRecolors(String blocks, int k) {

        int black = 0;
        for(int i=0;i<k;i++)
        {
            if(blocks.charAt(i) == 'B')
            {
                black++;
            }
        }

        int totalBlack = black;

        int i=1;
        int j=k;

        // char[] blockArray = blocks.toCharArray();

        while(j<blocks.length())
        {
            // char c1 = blocks.charAt(i);
            char c2 = blocks.charAt(j);
            char c3 = blocks.charAt(i-1);
            if(c2 == 'B' && c3 != 'B')
            {
                black++;
            }else if (c3 == 'B' && c2 == 'W')
            {
                black--;
            }

            totalBlack = Math.max(totalBlack,black);

            i++;
            j++;
        }

        return k - totalBlack;
        
    }
}