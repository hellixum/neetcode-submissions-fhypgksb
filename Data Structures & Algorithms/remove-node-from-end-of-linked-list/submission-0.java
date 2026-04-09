/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode travellerNode = head;
        Integer listSize = 1;
        while(travellerNode.next!= null) {
            travellerNode = travellerNode.next;
            listSize++;
        }

        if(n == listSize) {
            return head.next;
        }

        // [1, 2, 3, 4] -> Position    
        // [1, 2, 3, 4]
        // listSize = 4, n = 2, nodeToDelete = 3

        travellerNode = head;
        for(int i=1; i<listSize-n; i++) {
            travellerNode = travellerNode.next;
        }

        travellerNode.next = travellerNode.next.next;

        return head;
    }
}
