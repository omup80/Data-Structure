package cracking_the_coding_interview.linked_list;
/*
Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
as to make a loop in the linked list

 */
public class LoopDetection {
    ListNode FindBeginning(ListNode head) {
        ListNode slow =head;
        ListNode fast = head;

         /* Find meeting point. This will be LOOP_SIZE - k steps into the linked list. */
         while (fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
             if (slow == fast) {//Collision
                 break;
                 }
             }

         /* Error check - no meeting point, and therefore no loop*/
         if (fast == null || fast.next == null) {
             return null;
             }

         /* Move slow to Head. Keep fast at Meeting Point. Each are k steps from the
    20 * Loop Start. If they move at the same pace, they must meet at Loop Start . */
         slow = head;
         while (slow!= fast) {
             slow =slow.next;
             fast= fast.next;
             }

         /* Both now point to the start of the loop. */
         return fast;
         }


}


