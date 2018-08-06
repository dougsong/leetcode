class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x == 0) {
            return true;
        }

        int sum = 0;
        int temp = x;
        while (temp != 0) {
            sum = sum * 10 + temp % 10;
            temp /= 10;
        }

        if (sum == x) {
            return true;
        }
        return false;
    }
}