class ProductOfNumbers {
    ArrayList<Integer> al;

    public ProductOfNumbers() {
        al = new ArrayList<>();
    }
    
    public void add(int num) {
        int size = al.size();

        if(num == 0)
        {
            al.clear();
        }else if(size == 0)
        {
            al.add(num);
        }else{
            
            al.add(al.getLast() * num);
        }
        
    }
    
    public int getProduct(int k) {
        int size = al.size();
        if(k > size)
        {
            return 0;
        }else if(k == size)
        {
            return al.getLast();
        }

        int kthLast = al.get(size - 1 - k);
        int last = al.getLast();

        return last/kthLast;
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */