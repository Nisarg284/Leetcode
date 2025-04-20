class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        for(int i = 0;i<arr.length-1;i++)
        {
            int diff = Math.abs(arr[i] - arr[i+1]);

            min = Math.min(min,diff);

        }


        for(int i = 0;i<arr.length-1;i++)
        {
            int diff = Math.abs(arr[i] - arr[i+1]);
            if(diff == min)
            {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i+1]);
                ans.add(temp);
            }
        }
    
        return ans;
        
    }
}