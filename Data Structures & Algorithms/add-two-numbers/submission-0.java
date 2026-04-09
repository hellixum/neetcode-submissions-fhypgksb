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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addDigitsNode(l1, l2, 0);
    }

    ListNode addDigitsNode(ListNode node1, ListNode node2, int carry) {
        if(node1 == null && node2 == null && carry > 0) {
            return new ListNode(carry);
        } else if(node1 == null && node2 == null) {
            return null;
        }

        if(node1 == null) node1 = new ListNode(0);
        if(node2 == null) node2 = new ListNode(0);

        ListNode currentSum = new ListNode((node1.val + node2.val + carry)%10);
        int currentCarry = (node1.val + node2.val + carry)/10;

        currentSum.next = addDigitsNode(node1.next, node2.next, currentCarry);

        return currentSum;
    }
}
