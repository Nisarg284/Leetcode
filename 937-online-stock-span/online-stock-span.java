class StockSpanner {
    Stack<ArrayList<Integer>> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {

        int sp = 1;

        while(!st.isEmpty() && st.peek().get(0) <= price)
        {
            sp+=st.pop().get(1);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(price);
        ans.add(sp);
        st.push(ans);

        return sp;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */