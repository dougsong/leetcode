import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();

        if (n <= 0) {
            return list;
        }

        backtracking(list, "", 0, 0, n);
        return list;
    }

    private void backtracking(List<String> list, String str, int openParentheses, int closeParentheses, int pairs) {
        if (str.length() == (pairs * 2)) {
            list.add(str);
            return;
        }

        if (openParentheses < pairs) {
            backtracking(list, str + "(", openParentheses + 1, closeParentheses, pairs);
        }

        if (closeParentheses < openParentheses) {
            backtracking(list, str + ")", openParentheses, closeParentheses + 1, pairs);
        }
    }
}