class Solution {
    static class Pair implements Comparable<Pair>{
        int element;
        int distance;

        public Pair(int element,int distance)
        {
            this.element = element;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair p2)
        {
            if(this.distance == p2.distance)
            {
                // min heap property
                return p2.element - this.element;
            }
            else{
                // max heap property
                return p2.distance - this.distance;
            }
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        // define heap
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        //inserting Pair into pq
        for(int i=0;i<arr.length;i++)
        {
            // add pair
            pq.add(new Pair(arr[i],Math.abs(arr[i] - x)));

            // check when pq.size() > k then remove top pair
            if(pq.size() > k)
            {
                pq.remove();
            }
        }

        // define list for storing ans
        ArrayList<Integer> ans = new ArrayList<>();
        

        while(!pq.isEmpty())
        {
            ans.add(pq.peek().element);
            pq.remove();
        }

        Collections.sort(ans);
        return ans;
        
    }
}