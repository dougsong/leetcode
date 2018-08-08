/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null || l2 == null) {
            return (l1 == null) ? l2 : l1;
        }

        ListNode l3;
        if (l1.val < l2.val) {
            l3 = l1;
            l1 = l1.next;
        } else {
            l3 = l2;
            l2 = l2.next;
        }

        ListNode follow = l3;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                follow.next = l1;
                follow = l1;
                l1 = l1.next;
            } else {
                follow.next = l2;
                follow = l2;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            follow.next = l1;
            follow = l1;
            l1 = l1.next;
        }

        while (l2 != null) {
            follow.next = l2;
            follow = l2;
            l2 = l2.next;
        }

        return l3;
    }
}