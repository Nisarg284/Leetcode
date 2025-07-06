class Solution {
    public int findLucky(int[] arr) {
        
        int n = arr.length;
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i = 0;i<n;i++)
        {
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }

        int largest = -1;

        for(int i:hm.keySet())
        {
            int key = i;
            int val = hm.get(i);

            if(key == val)
            {
                if(key > largest)
                {
                    largest = key;
                }
                
            }
        }
        return largest;
    }
}