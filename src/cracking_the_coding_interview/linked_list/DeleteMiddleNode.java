package cracking_the_coding_interview.linked_list;


 // Definition for singly-linked list.

/*
Write a function to delete a node (except the tail) in a singly linked list,
 given only access to that node.
 */
class DeleteMiddleNode {
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null)
            return;
        
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
        nextNode = null;
        
    }
}