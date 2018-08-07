import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }

        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        list.add("");

        while (list.peek().length() != digits.length()) {
            String remove = list.remove();
            String chars = map[digits.charAt(remove.length()) - '0'];
            for (int j = 0; j < chars.length(); j++) {
                list.add(remove + chars.charAt(j));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        new Solution().letterCombinations("");
    }
}