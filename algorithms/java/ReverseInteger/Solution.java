class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        if (x < 0) {
            return 0;
        }

        long reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }

        if (reverse > Integer.MAX_VALUE) {
            return 0;
        }

        if (isNegative) {
            return (int) -reverse;
        }
        return (int) reverse;
    }
}