class LRUCache {

    // Define Node class for Double LinkedList
    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key,int val)
        {
            this.key  = key;
            this.val = val;
        }
    }

    // Define HashMap of <Integer,Node>
    HashMap<Integer,Node> hm;

    // define head & tail for eazyness
    private Node head;
    private Node tail;

    // Define capacity & size variable to track LRU size
    int capacity;
    int size;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.hm = new HashMap<>();
        this.size = 0;

        // initialize head & tail 
        head = new Node(0,0);
        tail = new Node(0,0);

        // now connect each other
        head.next = tail;
        tail.prev = head;
    }
    

    // Helper Functions
    // addAtFirst function
    public void addAtFirst(Node node)
    {
        node.next = head.next;
        node.prev = node.next.prev;
        node.prev.next = node;
        node.next.prev = node;
    }

    // removeNode function
    public void removeNode(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //moveToFirst Function
    public void moveToFirst(Node node)
    {
        // remove & acll addAtFirst function
        removeNode(node);
        addAtFirst(node);
    }
    
    public int get(int key) {
        Node temp = hm.get(key);

        // not exists case:
        if(temp == null)
        {
            return -1;
        }

        // move key to front & return that node value
        moveToFirst(temp);
        return temp.val;
    }
    
    public void put(int key, int value) {

        Node temp = hm.get(key);

        // already exists case:
        if(temp != null)
        {
            // update temp value to given value
            temp.val = value;
            moveToFirst(temp);
        }else{

            // not exists case:

            // create new Node
            Node newNode  = new Node(key,value);
            addAtFirst(newNode);
            hm.put(key,newNode);
            size++;

            // check if cache exceed it's capacity
            if(size > capacity)
            {
                Node n = tail.prev;
                removeNode(n);
                hm.remove(n.key);
                size--;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */