import java.util.PriorityQueue;

/**
 * 1. 排序
 * 2. 大根堆删除nums.length - k次
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }

        for (int i = 0; i < nums.length - k; i++) {
            heap.poll();
        }

        return heap.peek();
    }

    // TODO: 实现一个大根堆
}