class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int[] c  = new int[A.length];
        int count = 0;

        HashSet<Integer> hs = new HashSet<>();

        for(int i=0;i<A.length;i++)
        {
            // for A array
            if(hs.contains(A[i]))
            {
                count++;
                c[i] = count;
            }else{
                hs.add(A[i]);
            }

            // For B array
            if(hs.contains(B[i]))
            {
                count++;
                c[i] = count;
            }else{
                hs.add(B[i]);
            }

            if(c[i] == 0 && i!=0)
            {
                c[i] = c[i-1];
            }
        }

        return c;
        
    }
}