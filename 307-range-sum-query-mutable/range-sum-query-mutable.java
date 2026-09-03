class NumArray {

    private final int[]tree;
    private final int[]arr;
    private final int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.arr = nums.clone();
        this.tree = new int[n * 4]; 
        
        build(1,0,n-1);
    }

    public void build(int pos,int start,int end){
        if(start == end){
            tree[pos] = arr[start];
            return;
        }

        int leftChild = 2 * pos;
        int rightChild = 2 * pos + 1;

        int mid = start + (end - start) / 2;

        build(leftChild,start,mid);
        build(rightChild,mid + 1,end);

        tree[pos] = tree[leftChild] + tree[rightChild];
    }
    
    public void update(int index, int val) {

        if(index < 0 || index >= n){
            throw new IllegalArgumentException("Invalid Index");
        }

        update(1,0,n-1,index,val);
        
    }

    public void update(int pos,int start,int end,int idx,int val){
        if(start == end){
            arr[idx] = val;
            tree[pos] = val;
            return;
        }

        int leftChild = 2 * pos;
        int rightChild = 2 * pos + 1;

        int mid = start + (end - start) / 2;

        if(idx <= mid){
            update(leftChild,start,mid,idx,val);
        }else{
            update(rightChild,mid + 1,end,idx,val);
        }

        tree[pos] = tree[leftChild] + tree[rightChild];
    }
    
    public int sumRange(int left, int right) {

        if(left < 0 || right >= n || left > right){
            throw new IllegalArgumentException("Invalid range");
        }

        return sumRange(1,0,n-1,left,right);   
    }

    public int sumRange(int pos,int start,int end,int left,int right){
        if(left > end || right < start){
            return 0;
        }

        if(left <= start && right >= end){
            return tree[pos];
        }

        int leftPos = 2 * pos;
        int rightPos = 2 * pos + 1;

        int mid = start + (end - start) / 2;
        int leftChild = sumRange(leftPos,start,mid,left,right); 
        int rightChild = sumRange(rightPos,mid + 1,end,left,right); 

        return leftChild + rightChild;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */