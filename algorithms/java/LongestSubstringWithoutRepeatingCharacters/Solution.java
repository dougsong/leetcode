class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        char[] strArr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        int ans = 0;

        for (int i = 0, j = 0; j < strArr.length; j++) {
            if (map.containsKey(strArr[j])) {
                i = Math.max(i, map.get(strArr[j]));
            }

            ans = Math.max(ans, j - i + 1);
            map.put(strArr[j], j + 1);
        }

        return ans;
    }
}