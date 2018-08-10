/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    // PriorityQueue:Binary-Heap
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length <= 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {

            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.offer(list);
            }
        }

        if (priorityQueue.isEmpty()) {
            return null;
        }

        ListNode retHeadNode = null;
        ListNode newListNode = null;
        while (!priorityQueue.isEmpty()) {
            ListNode smallerNode = priorityQueue.poll();

            if (newListNode == null) {
                retHeadNode = smallerNode;
                newListNode = smallerNode;
            } else {
                newListNode.next = smallerNode;
                newListNode = newListNode.next;
            }

            smallerNode = smallerNode.next;
            if (smallerNode != null) {
                priorityQueue.offer(smallerNode);
            }
        }

        return retHeadNode;
    }
}