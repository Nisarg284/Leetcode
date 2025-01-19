class Solution {
    public long interchangeableRectangles(int[][] rectangles) {

        HashMap<Double,Integer> hm = new HashMap<>(); 

        long count = 0;

        for(int i=0;i<rectangles.length;i++)
        {   
            double ratio = (double)rectangles[i][0]/(double)rectangles[i][1];

            if(hm.containsKey(ratio))
            {
                count+=hm.get(ratio);
            }

            hm.put(ratio,hm.getOrDefault(ratio,0)+1);
        }

        return count;
    }
}