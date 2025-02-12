class Solution {

    public static int digitSum(int x)
    {
        int temp = x;
        int sum = 0;

        while(temp>0)
        {
            sum+=temp%10;
            temp/=10;

        }

        return sum;
    }

    public int maximumSum(int[] nums) {
        
        // define HashMap of Integer --> MaxHeap
        HashMap<Integer, PriorityQueue<Integer>> hm = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            int digiSum = digitSum(nums[i]);
            if(!hm.containsKey(digiSum))
            {
                PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
                pq.add(nums[i]);
                hm.put(digiSum,pq);
            }else{
                hm.get(digiSum).add(nums[i]);
            }
        }



        int maxSum = -1;
        for(int i:hm.keySet())
        {
            int size = hm.get(i).size();

            if(size >=2)
            {
                int firstEle = hm.get(i).remove();
                int secondEle = hm.get(i).remove();

                int sum = firstEle + secondEle;

                maxSum = Math.max(maxSum,sum);
            }
        }

        return maxSum;
    }
}