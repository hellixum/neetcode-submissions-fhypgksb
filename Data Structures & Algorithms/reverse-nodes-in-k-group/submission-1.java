class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = reverseNextNNodes(head, k);
        return ans;
    }

    ListNode reverseNextNNodes(ListNode head, int n) {
        if (head == null) return null;
        ListNode tailNode = head;
        for(int i=0; i < n - 1; i++) {
            if(tailNode == null || tailNode.next == null) return head;
            tailNode = tailNode.next;
        }

        ListNode nextPart = tailNode.next;
        reverseLinkedList(head, tailNode);
        head.next = reverseNextNNodes(nextPart, n);
        return tailNode;
    }

    ListNode reverseLinkedList(ListNode current, ListNode tail) {
        if(current == tail) {
            if (current != null) current.next = null;
            return current;
        }

        reverseLinkedList(current.next, tail).next = current;
        current.next = null;
        return current;
    }
}