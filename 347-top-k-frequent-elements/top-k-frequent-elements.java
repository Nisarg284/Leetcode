class Solution {

    static class Pair{
        int ele;
        int count;

        public Pair(int ele, int count) {
            this.ele = ele;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> hm = new HashMap<>();

        for(int i : nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair p1,Pair p2) -> p1.count - p2.count);

        for(Integer key : hm.keySet()){
            
            int ele = key;
            int count = hm.get(key);

            Pair p = new Pair(ele,count);

            pq.add(p);
            if(pq.size() > k){
                pq.remove();
            }
        }

        int[]ans = new int[k];

        for(int i = 0;i<k;i++){
            Pair p = pq.remove();
            ans[i] = p.ele;
        }

        return ans;


        
    }
}