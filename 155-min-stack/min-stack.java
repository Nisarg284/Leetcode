class MinStack {

    Stack<Integer> normal;
    Stack<Integer>min;

    public MinStack() {
        this.normal = new Stack<>();
        this.min = new Stack<>();
    }

    
    public void push(int val) {

        normal.push(val);

        if(min.isEmpty())
        {
            min.push(val);
        }

        else if(val <= min.peek())
        {
            min.push(val);
        }
        
    }
    
    public void pop() {

        if(normal.isEmpty())
        {
            return;
        }

        int topEle = normal.pop();

        if(min.peek() >= topEle)
        {
            min.pop();
        }

        
    }
    
    public int top() {

        return normal.peek();
        
    }
    
    public int getMin() {

        return min.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */