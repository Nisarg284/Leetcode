/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {

        if(head == null)
        {
            return head;
        }

        Node temp = head;

        while(temp!=null)
        {
            //traverse upto child node
            if(temp.child!=null)
            {
                Node newNext = temp.next;
                temp.next = flatten(temp.child);
                temp.next.prev = temp;
                temp.child=null;

                // traverse upto null
                while(temp.next!=null)
                {
                    temp = temp.next;
                }

                if(newNext!=null)
                {
                     temp.next = newNext;
                    newNext.prev = temp;
                }
            }
            temp = temp.next;
        }

        return head;
        
    }
}