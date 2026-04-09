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
    public ListNode mergeKLists(ListNode[] lists) {
        
        // min heap
        PriorityQueue<ListNode> listQueue = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);

        // m * log(m) -> m = lists.length
        for(ListNode node: lists) {
            listQueue.offer(node);
        }

        if(listQueue.isEmpty()) return null;

        ListNode head = new ListNode(0);
        ListNode tail = head;

        while(!listQueue.isEmpty()) {
            tail.next = listQueue.poll();
            tail = tail.next;

            if(tail.next != null) listQueue.offer(tail.next);
        }
        
        return head.next;
    }
}
