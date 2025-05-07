class Solution {
    public int findKthPositive(int[] arr, int k) {

        Set<Integer> missing = new HashSet<>();
        Set<Integer> having = new HashSet<>();

        int max = Integer.MIN_VALUE;

        for(int i = 0;i<arr.length;i++)
        {
            having.add(arr[i]);
            max = Math.max(arr[i],max);
        }

        int i = 1;

        while(missing.size() < k)
        {
            if(!having.contains(i))
            {
                missing.add(i);
            }
            i++;
        }

        return i-1;
        
    }
}