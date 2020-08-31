package java.p22GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack("", n, n, result);
        return result;
    }

    private void backTrack(String parenthesis, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(parenthesis);
            return;
        }

        if (right < left) {
            return;
        }

        if (left > 0) {
            backTrack(parenthesis + "(", left - 1, right, result);
        }

        if (right > 0) {
            backTrack(parenthesis + ")", left, right - 1, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(6));
    }
}