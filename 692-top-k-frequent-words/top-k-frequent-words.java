class Solution {

    static class Pair implements Comparable<Pair>{
        String str;
        int freq;

        public Pair(String str,int freq){
            this.str = str;
            this.freq = freq;
        }


        @Override
        public int compareTo(Pair p2)
        {
            if(p2.freq == this.freq)
            {
                return this.str.compareTo(p2.str);
            }

            return p2.freq - this.freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String,Integer> hm = new HashMap<>();

        for(int i=0;i<words.length;i++)
        {
            hm.put(words[i],hm.getOrDefault(words[i],0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
       

        for(String w:hm.keySet())
        {
            // Pair pr = new Pair(w,hm.get(w));

            // if(pq.size()> k)
            // {
            //     pq.remove();
            // }else{
            //     pq.add(pr);
            // }
            pq.add(new Pair(w,hm.get(w)));
        }


        List<String> ans  = new ArrayList<>();

        while(k>0)
        {
            ans.add(pq.remove().str);
            k--;
        }

        return ans;
        
    }
}