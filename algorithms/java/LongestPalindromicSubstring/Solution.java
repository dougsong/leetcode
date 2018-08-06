class Solution {

    boolean dp[][];

    public String longestPalindrome(String s) {
        dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i > j) {
                    continue;
                }
                if (i == j) {
                    dp[i][j] = true;
                } else if (j == (i + 1)) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
            }
        }


        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                if (i >= j || j == (i + 1)) {
                    continue;
                }

                dp[i][j] = (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j));
            }
        }

        int maxLength = 0, maxI = 0, maxJ = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i > j) {
                    continue;
                }

                if (dp[i][j] && (j - i + 1) > maxLength) {
                    maxLength = j - i + 1;
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        return s.substring(maxI, maxJ + 1);
    }

}