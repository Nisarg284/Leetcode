class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {


        int totalApples = Arrays.stream(apple).sum();

        Arrays.sort(capacity);

        int n = capacity.length;

        int count = 0;

        for(int i = n-1;i>=0;i--)
        {
            if(totalApples <= 0)
            {
                break;
            }
            totalApples -= capacity[i];
            count++;
        }

        return count;
        
    }
}