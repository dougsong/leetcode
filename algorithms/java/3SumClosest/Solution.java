import java.util.Arrays;

class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int minClosestSum = 0;
        int minDistance = Integer.MAX_VALUE;

        Arrays.sort(nums);

        int minIdx = 0, minLowIdx = 1, minHighIdx = nums.length - 1;
        for (int i = 0; i < nums.length - 2; i++) {
            int num = nums[i];
            int closest = target - num;

            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int twoSum = nums[low] + nums[high];

                int n;
                if ((n = Math.abs(twoSum - closest)) < minDistance) {
                    minDistance = n;
                    minIdx = i;
                    minLowIdx = low;
                    minHighIdx = high;
                }

                if (twoSum < closest) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return nums[minIdx] + nums[minLowIdx] + nums[minHighIdx];
    }
}