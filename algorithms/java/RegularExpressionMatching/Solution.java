public class Solution {

    /**
     * Approach 1: Recursion
     */
    public boolean isMatchByRecursion(String s, String p) {
        if (p == null || p.isEmpty()) {
            return (s == null) || (s.isEmpty());
        }

        boolean firstMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 通配符为*：
            // 1、*前面的字符出现0次
            // 2、*前面的字符出现一次
            // 3、*前面的字符出现多次
            return (isMatchByRecursion(s, p.substring(2)) ||
             (firstMatch && isMatchByRecursion(s.substring(1), p)));
        } else {
            return firstMatch && isMatchByRecursion(s.substring(1), p.substring(1));
        }
    }


    
    /**
     * Approach 2: Dynamic Programming
     */

    int[][] dp;
    /**
     * Top-Down Variation
     */
    public boolean isMatchByDP(String text, String pattern) {
        dp = new int[text.length() + 1][pattern.length() + 1];
        return calcDp(0, 0, text, pattern);
    }

    public boolean calcDp(int i, int j, String text, String pattern) {
        if (dp[i][j] != 0) {
            return dp[i][j] == 1 ? true : false;
        }

        boolean ans;
        if (j == pattern.length()) {
            // pattern已经匹配完毕，如果text也匹配完，表示pattern可以匹配text
            ans = (i == text.length());
        } else {
            // firstMatch：text[i]和pattern[j]是否匹配：
            // （1）两个字符相等
            // （2）pattern[j]为'.'
            boolean firstMatch = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                // pattern的下一个字符为'*'
                // calcDp(i, j + 2, text, pattern): pattern中'*' 前的字符出现0次
                // firstMatch && calcDp(i + 1, j, text, pattern))：pattern中'*' 前的字符出现1次或多次，
                // 若text和pattern出现的第一个字符相等，则继续往后匹配，此处需要注意*前的字符可能继续出现，因此pattern继续匹配的位置不变
                ans = (calcDp(i, j + 2, text, pattern) || firstMatch && calcDp(i + 1, j, text, pattern));
            } else {
                // pattern的下一个字符不为'*'
                ans = firstMatch && calcDp(i + 1, j + 1, text, pattern);
            }
        }

        dp[i][j] = ans ? 1 : -1;
        return ans;
    }


    /**
     * Bottom-Up Variation
     */
    public boolean isMatchByDP2(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean firstMatch = (i < text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.'));

                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}