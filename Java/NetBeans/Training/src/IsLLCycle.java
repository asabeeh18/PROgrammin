//https://www.hackerrank.com/challenges/ctci-linked-list-cycle
class IsLLCycle
{
    /*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    //Fast pointer technique
    if(head==null)
        return false;
    Node fast=head.next;
    Node slow=head;
    boolean cycle=false;
    while(slow.next!=null && fast.next!=null)
    {
        if(fast.equals(slow))
        {
            return true;
        }
        fast=fast.next.next;
        slow=slow.next;
    }
    return false;
}


class Node {
        int data;
        Node next;
    }
}