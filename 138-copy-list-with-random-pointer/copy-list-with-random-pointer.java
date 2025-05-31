class Solution {
    public Node copyRandomList(Node head) {

        // Node head2= new Node(head.val);
        // Node temp1=head;
        // Node temp2 = head2;

        // // create Deep copy
        // while(temp1!=null)
        // {
        //     temp1 = temp1.next;
        //     Node newNode = new Node(temp1.val);
        //     temp2.next = newNode;
        //     temp2 = temp2.next;
        // }

        // // create hashmap
        // HashMap<Node,Node> hm = new HashMap<>();

        // // put nodes into map

        // temp1 = head;
        // temp2 = head2;

        // while(temp1!= null)
        // {
        //     hm.put(temp1,temp2);
        //     temp1=temp1.next;
        //     temp2 = temp2.next;
        // }

        // // iterate in map
        // for(Node i : hm.keySet())
        // {
        //     Node first = i;
        //     Node second = hm.get(i);
        //     if(hm.containsKey(first.random))
        //     {
        //         if(hm.get(first.random)==null)
        //         {
        //             second.random = null;
        //         }
        //         else{
        //             second.random = hm.get(first.random);
        //         }
                
        //     }

            
        // }

        // return head2;

        if(head == null)
        {
            return head;
        }
        Node head2 = new Node(head.val);

       Node temp1 = head;
       Node temp2 = head2;

       while (temp1.next!=null)
       {
           temp1= temp1.next;
           Node newNode = new Node(temp1.val);
           temp2.next = newNode;
           temp2 = temp2.next;
       }



        // put random pointer into new LinkedList
       HashMap<Node,Node> map = new HashMap<>();

       temp1 = head;
       temp2 = head2;

       while (temp1!=null)
       {
           map.put(temp1,temp2);
           temp1=temp1.next;
           temp2 = temp2.next;
       }

       for (Node i : map.keySet())
       {
           Node first = i;
           Node second = map.get(i);

           if(map.containsKey(first.random))
           {   
            second.random = map.get(first.random); 
           }

        //    if(first.random == null)
        //    {
        //     second.random = null;
        //    }


       }

       return head2;
        
    }
}