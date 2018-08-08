import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> conbines = new LinkedList<>();
        if (nums == null || nums.length < 4) {
            return conbines;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int findTarget = target - nums[i];
                List<List<Integer>> threeSumList = threeSum(Arrays.copyOfRange(nums, i + 1, nums.length), findTarget);

                if (threeSumList == null || threeSumList.size() <= 0) {
                    continue;
                }

                for (List<Integer> list : threeSumList) {
                    List<Integer> l = new LinkedList<>();
                    l.add(nums[i]);
                    l.addAll(list);
                    conbines.add(l);
                }
            }
        }

        return conbines;
    }

    private List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int findTarget = target - nums[i];
                int low = i + 1, high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] == findTarget) {
                        lists.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }

                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }

                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < findTarget) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }

        return lists;
    }
}