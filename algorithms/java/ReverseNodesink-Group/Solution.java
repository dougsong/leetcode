/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode newHead = head;
        ListNode nextReverseList = head;
        for (int i = 0; i < k; i++) {
            if (nextReverseList == null) {
                return head;
            }
            newHead = nextReverseList;
            nextReverseList = nextReverseList.next;
        }

        ListNode current = head.next;
        head.next = reverseKGroup(nextReverseList, k);
        ListNode preNode = head;
        while (current != newHead) {
            ListNode tmp = current.next;
            current.next = preNode;
            preNode = current;
            current = tmp;
        }
        current.next = preNode;
        return newHead;
    }
}