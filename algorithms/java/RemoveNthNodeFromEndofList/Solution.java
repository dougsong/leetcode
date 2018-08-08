/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode frontNode = head;
        for (int i = 0; i < n - 1; i++) {
            if (frontNode == null) {
                // 链表节点数小于n
                return null;
            }
            frontNode = frontNode.next;
        }

        ListNode removeNodePointer = head;
        ListNode preNode = head;

        while (frontNode.next != null) {
            frontNode = frontNode.next;
            preNode = removeNodePointer;
            removeNodePointer = removeNodePointer.next;
        }

        if (head == removeNodePointer) {
            return head.next;
        }

        preNode.next = removeNodePointer.next;
        return head;
    }
}