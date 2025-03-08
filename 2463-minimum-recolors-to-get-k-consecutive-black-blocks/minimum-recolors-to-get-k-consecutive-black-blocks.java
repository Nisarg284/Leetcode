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

        char[] blockArray = blocks.toCharArray();

        while(j<blockArray.length)
        {
            if(blockArray[j] == 'B' && blockArray[i-1] != 'B')
            {
                black++;
            }else if (blockArray[i-1] == 'B' && blockArray[j] == 'W')
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