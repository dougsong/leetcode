class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int complement = 0;
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (map.containsKey(complement) && i != map.get(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No such nums!");
    }
}