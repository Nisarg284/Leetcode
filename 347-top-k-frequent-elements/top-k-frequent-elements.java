class Solution {
    public class Pair{
        int ele;
        int freq;

        public Pair(int ele,int freq){
            this.ele = ele;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {

    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.freq - b.freq);
    HashMap<Integer,Pair> hm = new HashMap<>();

    for(int i : nums){

        if(hm.containsKey(i)){
            Pair p = hm.get(i);
            p.freq++;
            hm.put(i,p);
        }else{
            hm.put(i,new Pair(i,1));
        }
    }

    for(int i : hm.keySet()){

        pq.add(hm.get(i));

        if(pq.size() > k){
            pq.remove();
        }
    }

    int[] ans = new int[k];
    int idx = 0;

    while(!pq.isEmpty()){
        ans[idx++] = pq.remove().ele;
    }

    return ans;
        
    }
}