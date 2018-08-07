class Solution {

    public int romanToInt(String s) {
        int prev = 10000;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int num = helper(s.charAt(i));
            sum += num;
            if (num > prev) {
                sum -= prev * 2;
            }
            prev = num;
        }
        return sum;
    }

    private int helper(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}